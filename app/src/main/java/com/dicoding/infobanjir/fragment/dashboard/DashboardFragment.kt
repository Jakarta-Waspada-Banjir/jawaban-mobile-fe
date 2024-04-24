package com.dicoding.infobanjir.fragment.dashboard

import android.os.*
import android.view.*
import androidx.fragment.app.*
import androidx.recyclerview.widget.*
import com.dicoding.infobanjir.core.ui.*
import com.dicoding.infobanjir.databinding.*
import org.koin.androidx.viewmodel.ext.android.*

class DashboardFragment : Fragment() {
    private val dashboardViewModel: DashboardViewModel by viewModel()
    private lateinit var binding: FragmentDashboardBinding
    private val weatherAdapter: WeatherAdapter by lazy { WeatherAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeDashboardData()
    }

    private fun observeDashboardData() {

    }

    private fun setupRecyclerView() {
        with(binding.rvWeather) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = weatherAdapter
        }
    }
}
