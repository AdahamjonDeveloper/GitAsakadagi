package uz.digital.gitasakadagi

import android.content.Context
import android.content.SharedPreferences

const val Tasbex_Name = "App"
const val Counter = "Counter"

class PrefManager {

    companion object {
        private fun getInstance(ctx: Context): SharedPreferences {
            return ctx.getSharedPreferences(Tasbex_Name,Context.MODE_PRIVATE)
        }

        // tasbex

        fun saveCache(ctx: Context,str : String){
            getInstance(ctx).edit().putString(Tasbex_Name,str).apply()
        }
        fun getCaChe(ctx: Context):String{
            return getInstance(ctx).getString(Tasbex_Name,"0").toString()
        }

        // counter

        fun saveCounter(ctx: Context,count : String){
            getInstance(ctx).edit().putString(Counter,count).apply()
        }
        fun getCounter(ctx: Context):String{
            return getInstance(ctx).getString(Counter,"0").toString()
        }

    }
}