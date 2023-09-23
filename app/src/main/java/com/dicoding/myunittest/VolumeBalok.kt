package com.dicoding.myunittest

class VolumeBalok {

    private var  width = 0.0
    private var  length = 0.0
    private var  height = 0.0

    fun getVolume(): Double = width * length * height

    fun  getSurfaceArea(): Double {
        var wl = width * length
        var wh = width * height
        var lh = length * height

        return 2 * (wl + wh + lh)

    }
    fun getCircumference(): Double = 4 * (width + length + height)
    
    fun save (width: Double, length: Double, height: Double) {
        this.width = width
        this.length = length
        this.height = height
    }
}