package com.example.cleanarchitecture.ui.main

import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.base.BaseActivity
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.ui.extensions.hideNavigationUI
import com.example.cleanarchitecture.ui.extensions.showLongToastMessage
import com.example.cleanarchitecture.util.BitmapSaveUtils
import com.example.cleanarchitecture.util.BitmapSaveUtils.PERMISSIONS_REQUEST_SAVE_PICTURE
import com.example.cleanarchitecture.util.BitmapSaveUtils.saveImageForBackgroundOfView
import com.example.cleanarchitecture.util.ShakeDetector
import com.example.cleanarchitecture.util.ShakeDetector.OnShakeListener
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {
    override val viewModel: MainViewModel by viewModel()

    // The following are used for the shake detection
    private val sensorManager: SensorManager by lazy { getSystemService(SENSOR_SERVICE) as SensorManager }
    private val accelerometer: Sensor by lazy { sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) }
    private val shakeDetector: ShakeDetector by lazy { ShakeDetector() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideNavigationUI()
        // ShakeDetector initialization
        shakeDetector.setOnShakeListener(object : OnShakeListener {
            override fun onShake() {
                saveSmartCatImage()
            }
        })
    }

    override fun onResume() {
        super.onResume()
        // Add the following line to register the Session Manager Listener onResume
        sensorManager.registerListener(
            shakeDetector,
            accelerometer,
            SensorManager.SENSOR_DELAY_UI
        )
    }

    override fun onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        sensorManager.unregisterListener(shakeDetector)
        super.onPause()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == PERMISSIONS_REQUEST_SAVE_PICTURE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                saveSmartCatImage()
            } else {
                showPermissionDeniedUI()
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun saveSmartCatImage() {
        saveImageForBackgroundOfView(
            this,
            viewDataBinding.layoutRoot,
            object : BitmapSaveUtils.SaveImageCallBack {
                override fun onSuccess() {
                    showSuccessToSaveImageUI()
                }

                override fun onFail() {
                    showFailToSaveImageUI()
                }
            })
    }

    private fun showPermissionDeniedUI() {
        showLongToastMessage(getString(R.string.main_save_permission_is_need))
    }

    private fun showFailToSaveImageUI() {
        showLongToastMessage(getString(R.string.main_fail_to_save_image))
    }

    private fun showSuccessToSaveImageUI() {
        showLongToastMessage(getString(R.string.main_success_to_save_image))
    }
}