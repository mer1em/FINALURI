package com.example.finaluri.fragments2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finaluri.R
import com.example.finaluri.dataclass.DataClassGood
import com.example.finaluri.pagers.RecyclerGood
import java.util.ArrayList

class ReceipeFragment : Fragment(R.layout.fragment_receipe) {

    private lateinit var recyclerView : RecyclerView
    private lateinit var recyclerGood : RecyclerGood

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView = view.findViewById(R.id.recyclerViewGood)
        recyclerGood = RecyclerGood(data())
        recyclerView.layoutManager = LinearLayoutManager(this@ReceipeFragment.requireContext())
        recyclerView.adapter = recyclerGood
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()

}


    private fun data() : List<DataClassGood> {
        var receipeList = ArrayList<DataClassGood>()
        receipeList.add(
            DataClassGood(
                1,
                "https://assets.epicurious.com/photos/5c745a108918ee7ab68daf79/6:4/w_3756,h_2504,c_limit/Smashburger-recipe-120219.jpg",
                "Burger",
                "1."
            )
        )

        receipeList.add(
            DataClassGood(
                2,
                "https://assets.epicurious.com/photos/63639804057b81ce50272868/1:1/w_1920,c_limit/0510-barbecue-mushroom-pizza-lede.jpg",
                "pizza",
                "2."
            )
        )

        receipeList.add(
            DataClassGood(
                3,
                "https://assets.epicurious.com/photos/6360f7609483381a1719b59f/1:1/w_1920,c_limit/2022-VG-BA-PASTA-Spaghetti-12123.jpg",
                "Spaghetti ",
                "3."
            )
        )

        receipeList.add(
            DataClassGood(
                4,
                "https://assets.epicurious.com/photos/63c163fa1d052f6441bdd24a/1:1/w_1920,c_limit/20221215-1222-SEO-RECIPES-25192%201-HIRES.jpg",
                "cake",
                "4."
            )
        )

        receipeList.add(
            DataClassGood(
                5,
                "https://assets.epicurious.com/photos/637bf0156a605187a5ce0b0c/1:1/w_1920,c_limit/EasyFriedRice_RECIPE_111722_42638.jpg",
                "Fried Rice",
                "5."
            )
        )

        receipeList.add(
            DataClassGood(
                6,
                "https://assets.epicurious.com/photos/61f4371bc818216ce82c8465/1:1/w_1920,c_limit/LemonyShrimpRisotto_RECIPE_012622_26486.jpg",
                "Risotto",
                "6."
            )
        )

        receipeList.add(
            DataClassGood(
                7,
                "https://www.sciencekids.co.nz/images/pictures/flags680/Brazil.jpg",
                "Brazil",
                "7."
            )
        )

        receipeList.add(
            DataClassGood(
                8,
                "https://assets.epicurious.com/photos/639b8324e8e503928cf409ca/1:1/w_1920,c_limit/Cabbage%20Slaw-RECIPE.jpeg",
                "Cabbage Salad",
                "8."
            )
        )


        receipeList.add(
            DataClassGood(
                9,
                "https://assets.epicurious.com/photos/63c9856b812d0cc95df16228/1:1/w_1920,c_limit/BobbyBurns_RECIPE_011323_45720.jpg",
                "Bobby Burns",
                "9."
            )
        )

        receipeList.add(
            DataClassGood(
                10,
                "https://assets.epicurious.com/photos/6360f66190c5649b153ba913/1:1/w_1920,c_limit/0801-tofu.jpg",
                "Tofu",
                "10."
            )
        )

        receipeList.add(
            DataClassGood(
                11,
                "https://assets.epicurious.com/photos/628ba0d3fa016bab2139efa2/1:1/w_1920,c_limit/Gyoza_RECIPE_051922_34332.jpg",
                "Gyoza",
                "11. "
            )
        )


        receipeList.add(
            DataClassGood(
                12,
                "https://assets.epicurious.com/photos/63693ca3753e7d5ebca8d927/1:1/w_1920,c_limit/GingerbreadCookies_RECIPE_110222_41407.jpg",
                "Cookies",
                "12. "
            )
        )


        return receipeList
    }



}