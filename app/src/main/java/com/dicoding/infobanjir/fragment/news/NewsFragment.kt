package com.dicoding.infobanjir.fragment.news

import android.os.*
import android.view.*
import androidx.fragment.app.*
import com.dicoding.infobanjir.*

class NewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }
}