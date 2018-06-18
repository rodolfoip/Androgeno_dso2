package br.ufsc.rodolfo.brasilnarussia

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var lat: String
    private lateinit var lng: String
    private lateinit var title: String

    companion object {
        const val EXTRA_LAT = "lat"
        const val EXTRA_LNG = "lng"
        const val EXTRA_TITLE = "title"

        fun newIntent(context: Context, cronograma: CronogramaJogos): Intent {
            val cronogramaIntent = Intent(context, MapsActivity::class.java)

            cronogramaIntent.putExtra(EXTRA_LAT, cronograma.lat)
            cronogramaIntent.putExtra(EXTRA_LNG, cronograma.lng)
            cronogramaIntent.putExtra(EXTRA_TITLE, cronograma.local)

            return cronogramaIntent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        lat = intent.extras.getString(EXTRA_LAT)
        lng = intent.extras.getString(EXTRA_LNG)
        title = intent.extras.getString(EXTRA_TITLE)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val local = LatLng(lat.toDouble(), lng.toDouble())
        mMap.addMarker(MarkerOptions().position(local).title(title))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(local))
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12.0f))
    }
}
