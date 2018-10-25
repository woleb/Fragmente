package com.example.it_wog.fragmente


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ErstesFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ErstesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var fragmentTextFeld: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val mView = inflater?.inflate(R.layout.fragment_erstes, container, false)
        fragmentTextFeld = mView?.findViewById<EditText>(R.id.editFragment1)

        val button1 = mView?.findViewById<Button>(R.id.buttonFragment1)
        button1?.setOnClickListener {
            Log.i("TEST", "Textfeld: ${fragmentTextFeld?.text}")
            oeffneFragment()
        }

        // Inflate the layout for this fragment
        return mView
    }

    fun laenge (){
        val text =fragmentTextFeld?.text.toString()
        val textLength = text.length
        Log.i("TEST", "Die Länge ist ${textLength}")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        laenge()
    }

    fun oeffneFragment () {
        val daten : Bundle = Bundle()
        daten.putString("name", fragmentTextFeld?.text.toString() )
        daten.putString("testDaten", "ABCD")

        val zweitesFragment = ZweitesFragment()
        zweitesFragment.arguments = daten
        this.fragmentManager?.beginTransaction()
            ?.replace(R.id.fragmentPlatz,zweitesFragment)
            ?.addToBackStack(null)
            ?.commit()

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ErstesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ErstesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
