package com.dicoding.myunittest

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.myunittest.Models.MainViewModel
import com.dicoding.myunittest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        mainViewModel = MainViewModel(VolumeBalok())
        activityMainBinding.btnSave.setOnClickListener(this)
        activityMainBinding.btnCalculateSurfaceArea.setOnClickListener(this)
        activityMainBinding.btnCalculateCircumference.setOnClickListener(this)
        activityMainBinding.btnCalculateVolume.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val length = activityMainBinding.edtLength.text.toString().trim()
        val width = activityMainBinding.edtWidth.text.toString().trim()
        val height = activityMainBinding.edtHeight.text.toString().trim()

        when {
            TextUtils.isEmpty(length) -> {
                activityMainBinding.edtLength.error = "text ini jangan boleh kosong"
            }

            TextUtils.isEmpty(width) -> {
                activityMainBinding.edtWidth.error = "text ini jangan boleh kosong"
            }

            TextUtils.isEmpty(height) -> {
                activityMainBinding.edtHeight.error = "text ini jangan boleh kosong"
            }

            else -> {
                val valueLength = length.toDouble()
                val valueWidth = width.toDouble()
                val valueHeight = height.toDouble()
                when (v.id) {
                    R.id.btn_save -> {
                        mainViewModel.save(valueLength, valueWidth, valueHeight)
                        visible()
                    }

                    R.id.btn_calculate_circumference -> {
                        activityMainBinding.tvResult.text =
                            mainViewModel.getCircumference().toString()
                        gone()
                    }

                    R.id.btn_calculate_surface_area -> {
                        activityMainBinding.tvResult.text =
                            mainViewModel.getSurfaceArea().toString()
                        gone()
                    }

                    R.id.btn_calculate_volume -> {
                        activityMainBinding.tvResult.text = mainViewModel.getVolume().toString()
                        gone()
                    }
                }
            }

        }
    }

    private fun visible() {
        activityMainBinding.btnCalculateVolume.visibility = View.VISIBLE
        activityMainBinding.btnCalculateCircumference.visibility = View.VISIBLE
        activityMainBinding.btnCalculateSurfaceArea.visibility = View.VISIBLE
        activityMainBinding.btnSave.visibility = View.VISIBLE
    }

    private fun gone() {
        activityMainBinding.btnCalculateVolume.visibility = View.GONE
        activityMainBinding.btnCalculateCircumference.visibility = View.GONE
        activityMainBinding.btnCalculateSurfaceArea.visibility = View.GONE
        activityMainBinding.btnSave.visibility = View.VISIBLE
    }
}