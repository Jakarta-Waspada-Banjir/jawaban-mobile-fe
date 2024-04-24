package com.dicoding.infobanjir.fragment.contact

import android.os.*
import android.view.*
import androidx.fragment.app.*
import com.dicoding.infobanjir.*

class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }
}