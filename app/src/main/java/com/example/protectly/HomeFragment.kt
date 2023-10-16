package com.example.protectly

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private lateinit var profile: ImageView
    private lateinit var settings: ImageView
    private lateinit var mapBtn: Button

    private lateinit var recyclerView: RecyclerView
    private var artikel = ArrayList<ArtikelDataClassHome>()
    private lateinit var artikelAdapterHome: ArtikelAdapterHome

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        profile = view.findViewById(R.id.img_profile)
        settings = view.findViewById(R.id.icon_settings)
        mapBtn = view.findViewById(R.id.lokasi_btn)

        recyclerView = view.findViewById(R.id.recycler_artikel_home)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        init()
        artikelAdapterHome = ArtikelAdapterHome(artikel)
        recyclerView.adapter = artikelAdapterHome

        profile.setOnClickListener(this)
        settings.setOnClickListener(this)
        mapBtn.setOnClickListener(this)
        return view

    }
    private fun init(){
        artikel.add(ArtikelDataClassHome(
            gambar = R.drawable.gambar_artikel_1,
            profilePenulis = R.drawable.img_penulis_kompas,
            namaPenulis = "Kompasiana",
            tanggal = "6 Agustus 2023",
            judul = "Pelaku kejahatan tindak di hukum? Kok bisa?",
            kutipan = "Tidak semua pelaku kejahatan dihukum, Kok bisa? Sini kenalan dulu sama alasan"
            )
        )
        artikel.add(ArtikelDataClassHome(
            gambar = R.drawable.gambar_artikel_2,
            profilePenulis = R.drawable.img_penulis_kompas,
            namaPenulis = "Kompasiana",
            tanggal = "4 Agustus 2023",
            judul = "Renungan mengapa kriminalitas di Medan terus tumbuh: Apa Kita Turut Melastirakannya?",
            kutipan = "Masalah di bedan adalah ketimpangan entah itu ekonomi atau pendidikan."
            )
        )
        artikel.add(ArtikelDataClassHome(
            gambar = R.drawable.gambar_artikel_3,
            profilePenulis = R.drawable.img_penulis_kompas,
            namaPenulis = "Kompasiana",
            tanggal = "6 Agustus 2023",
            judul = "Begal : Berlindung di balik HAM?",
            kutipan = "Sampai saat ini begal masih menjadi trending topik bagi masyarakat Kota Medan, Sumatra Utara."
            )
        )
        artikel.add(ArtikelDataClassHome(
            gambar = R.drawable.gambar_artikel_4,
            profilePenulis = R.drawable.img_penulis_tribun,
            namaPenulis = "Tribun Jabar",
            tanggal = "18 Juli 2023",
            judul = "Kasus korban melawan dan membunuh begal terjadi di Bekasi, Jawa Barat",
            kutipan = "Ada 60 lebih titik tempat dimana cctv dipasang di sekitaran Medan, hal ini tujuannya memantau pergerakan begal yang sedang heboh di Medan."
            )
        )
        artikel.add(ArtikelDataClassHome(
            gambar = R.drawable.gambar_artikel_5,
            profilePenulis = R.drawable.img_penulis_detik,
            namaPenulis = "Detik Sumut",
            tanggal = "27 September 2023",
            judul = "2 bulan buron, Pembobolan Ruko Berkolor di Batam di bekuk Polisi.",
            kutipan = "Seorang pria berinisial VD (37), pelaku pencurian di Ruko Samping Pintu Batamindo, Sei Beduk, Kota Batam dibekuk polisi setelah buron selama dua bulan."
            )
        )
        artikel.add(ArtikelDataClassHome(
            gambar = R.drawable.gambar_artikel_6,
            profilePenulis = R.drawable.img_penulis_detik,
            namaPenulis = "Detik News",
            tanggal = "26 September 2023",
            judul = "Viral Peria Mengendap-endap Curi Ponsel Di kos Jatim. Polisi kejar pelaku",
            kutipan = "Polisi mengaku sudah menerima laporan dan saat ini sedang mengejar terduga pelaku."
        )
        )
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.img_profile -> {
                val intent = Intent(requireActivity(), ProfileActivity::class.java)
                startActivity(intent)
            }
            R.id.icon_settings -> {
                val intent = Intent(requireActivity(), SettingsActivity::class.java)
                startActivity(intent)
            }
            R.id.lokasi_btn -> {
                val intent = Intent(requireActivity(), LokasiActivity2::class.java)
                startActivity(intent)
            }
        }
    }

}