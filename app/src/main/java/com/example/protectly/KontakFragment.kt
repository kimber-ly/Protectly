
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.protectly.PagerAdapterKontak
import com.example.protectly.R
import com.google.android.material.tabs.TabLayout

class KontakFragment : Fragment() {
    private lateinit var tab: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_kontak, container, false)
        viewPager = view.findViewById(R.id.viewPager)

        val adapter = PagerAdapterKontak(childFragmentManager)
        viewPager.adapter = adapter

        tab = view.findViewById(R.id.tab_kontak)

        tab.setupWithViewPager(viewPager)

        return view
    }

}
