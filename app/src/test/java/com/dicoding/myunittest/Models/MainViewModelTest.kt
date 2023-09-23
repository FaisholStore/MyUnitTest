package com.dicoding.myunittest.Models
import com.dicoding.myunittest.VolumeBalok
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.junit.Assert.assertEquals

class MainViewModelTest {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var volumeBalok: VolumeBalok

    private val dummyLength = 12.0
    private val dummyWidth = 7.0
    private val dummyHeight = 6.0
    private val dummyVolume = 504.0
    private val dummyCircumference = 100.0
    private val dummySurfaceArea = 396.0

    @Before
    fun before() {
        // Mock VolumeBalok
        volumeBalok = mock(VolumeBalok::class.java)

        // Konfigurasikan respons dari volumeBalok saat metode getVolume dipanggil
        `when`(volumeBalok.getVolume()).thenReturn(dummyVolume)

        // Konfigurasikan respons dari volumeBalok saat metode getSurfaceArea dipanggil
        `when`(volumeBalok.getSurfaceArea()).thenReturn(dummySurfaceArea)

        // Inisialisasi MainViewModel dengan objek VolumeBalok yang telah di-mock dalam blok @Before
        mainViewModel = MainViewModel(volumeBalok)
    }

    @Test
    fun testVolume() {
        // Memastikan objek MainViewModel menghitung volume dengan benar
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight)
        val volume = mainViewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }

    @Test
    fun getSurfaceArea() {
        // Memastikan objek MainViewModel mengambil luas permukaan dengan benar
        val surfaceArea = mainViewModel.getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }

    @Test
    fun getVolume() {
        // Memastikan objek MainViewModel mengambil volume dengan benar
        val volume = mainViewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }
    @Test
    fun getCircumference() {
        // Memastikan objek MainViewModel mengambil keliling dengan benar
        // Konfigurasi respons dari volumeBalok saat metode getCircumference dipanggil
        `when`(volumeBalok.getCircumference()).thenReturn(dummyCircumference)

        val circumference = mainViewModel.getCircumference()
        assertEquals(dummyCircumference, circumference, 0.0001)
    }
    @Test
    fun save() {
        // Memastikan objek MainViewModel dapat menyimpan data dengan benar
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight)
        val volume = mainViewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }
}
