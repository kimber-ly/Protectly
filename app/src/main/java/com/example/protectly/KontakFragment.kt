
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.protectly.Kontak_Fragment
import com.example.protectly.ListAdapter
import com.example.protectly.ListKontak
import com.example.protectly.Pesan_Fragment
import com.example.protectly.R
import com.google.android.material.tabs.TabLayout

class KontakFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var mList = ArrayList<ListKontak>()
    private lateinit var adapter: ListAdapter
    private lateinit var tab: TabLayout
    private var currentFragment: Fragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_kontak, container, false)
        tab = view.findViewById(R.id.tab_kontak)
        currentFragment = Kontak_Fragment()
        fragment(Kontak_Fragment())

        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.id){
                    R.id.tab1 -> fragment(Kontak_Fragment())
                    R.id.tab2 -> fragment(Pesan_Fragment())
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                fragment(currentFragment ?: Kontak_Fragment())
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                fragment(currentFragment ?: Kontak_Fragment())
            }

        })


//        recyclerView = view.findViewById(R.id.listView)
//
//        recyclerView.setHasFixedSize(true)
//        recyclerView.layoutManager = LinearLayoutManager(context)
//        addDataToList()
//        adapter = ListAdapter(mList)
//        recyclerView.adapter = adapter

        return view
    }

    private fun fragment(fragment: Fragment){
        val transaction: FragmentTransaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.kontak_container, fragment)
        transaction.commit()
    }

    private fun addDataToList() {
        mList.add(ListKontak("Polisi", "112", R.drawable.img_kontak2))
        mList.add(ListKontak("Ayah", "+62 8967821", R.drawable.img_kontak3))
        mList.add(ListKontak("Ibu", "+62 7801569", R.drawable.img_kontak4))
        mList.add(ListKontak("Bestie", "+62 7118450", R.drawable.img_kontak5))
        mList.add(ListKontak("Abang", "+62 2186610", R.drawable.img_kontak6))
        mList.add(ListKontak("Pak RT", "+62 896778", R.drawable.img_kontak_6))
    }
}
