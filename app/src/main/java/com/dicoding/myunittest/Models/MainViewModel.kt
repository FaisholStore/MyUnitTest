package com.dicoding.myunittest.Models

import com.dicoding.myunittest.VolumeBalok

class MainViewModel (private val volumeBalok: VolumeBalok){

    fun  getCircumference () = volumeBalok.getCircumference()
    fun  getSurfaceArea () = volumeBalok.getSurfaceArea()
    fun getVolume() = volumeBalok.getVolume()

    fun save (w: Double, l: Double, h: Double){
        volumeBalok.save(w, l, h)
    }

}