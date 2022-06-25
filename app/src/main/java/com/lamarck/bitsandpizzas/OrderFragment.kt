package com.lamarck.bitsandpizzas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.lamarck.bitsandpizzas.databinding.FragmentOrderBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OrderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderFragment : Fragment() {
    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //val view =inflater.inflate(R.layout.fragment_order, container, false)
        //val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        _binding = FragmentOrderBinding.inflate(inflater,container,false)
        val view = binding.root
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

       // val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        binding.fab.setOnClickListener {
            //val pizzaGroup = view.findViewById<RadioGroup>(R.id.pizza_group)
            val pizzaType = binding.pizzaGroup.checkedRadioButtonId

            if (pizzaType==-1){
                val text ="You need to choose a pizza type"
                Toast.makeText(activity,text,Toast.LENGTH_LONG).show()
            }else{
                var text =(when(pizzaType){
                    R.id.radio_diavolo -> "Diavolo pizza"
                    else -> "Funghi pizza"
                })

               // val parmesan = view.findViewById<Chip>(R.id.parmesan)
                text += if (binding.parmesan.isChecked) ",extras parmesan" else ""
                //val chiliOil = view.findViewById<Chip>(R.id.chili_oil)
                text += if (binding.chiliOil.isChecked) ", extras chili oil" else ""
                Snackbar.make(binding.fab,text,Snackbar.LENGTH_LONG).show()
            }
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


}