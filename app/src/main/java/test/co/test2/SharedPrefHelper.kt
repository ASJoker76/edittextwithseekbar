package test.co.test2

import android.content.Context

class SharedPrefHelper {

    companion object {
        const val DONOTCOMEAGAIN:String ="DONOTCOMEAGAIN"

        fun setString(context: Context, key: String, value: String) {
            val edit = context.applicationContext.getSharedPreferences(C.SHARE_PREF, 0).edit()
            edit.putString(key, value)
            edit.apply()
        }

        fun getString(context: Context, key: String): String? {
            return context.applicationContext.getSharedPreferences(C.SHARE_PREF, 0).getString(key, "")
        }

        fun getString(context: Context, key: String, default:String): String? {
            return context.applicationContext.getSharedPreferences(C.SHARE_PREF, 0).getString(key, default)
        }


        fun setBoolean(context: Context, key: String, value: Boolean?) {
            val edit = context.applicationContext.getSharedPreferences(C.SHARE_PREF, 0).edit()
            edit.putBoolean(key, value!!)
            edit.apply()
        }

        @JvmOverloads
        fun getBoolean(context: Context, key: String, def: Boolean = false): Boolean {
            return context.applicationContext.getSharedPreferences(C.SHARE_PREF, 0).getBoolean(key, def)
        }

        fun setDouble(context: Context, key: String, value: Double?) {
            val edit = context.applicationContext.getSharedPreferences(C.SHARE_PREF, 0).edit()
            edit.putString(key, value.toString())
            edit.apply()
        }

        @JvmOverloads
        fun getDouble(context: Context, key: String, def: Double? = 0.0): Double {
            return java.lang.Double.valueOf(context.applicationContext.getSharedPreferences(C.SHARE_PREF, 0).getString(key, def.toString())!!)
        }

        fun setInt(context: Context, key: String, value: Int) {
            val edit = context.applicationContext.getSharedPreferences(C.SHARE_PREF, 0).edit()
            edit.putInt(key, value)
            edit.apply()
        }

        @JvmOverloads
        fun getInt(context: Context, key: String, def: Int = 0): Int {
            return context.applicationContext.getSharedPreferences(C.SHARE_PREF, 0).getInt(key, def)
        }

        fun setIntNew(context: Context, key: String, value: Int) {
            val edit = context.applicationContext.getSharedPreferences(C.SHARE_PREF, 0).edit()
            edit.putInt(key, value)
            edit.apply()
        }

        @JvmOverloads
        fun getIntNew(context: Context, key: String, def: Int = 0): Int {
            return context.applicationContext.getSharedPreferences(C.SHARE_PREF, 0).getInt(key, def)
        }


        fun setLong(context: Context, key: String, value: Long) {
            val edit = context.applicationContext.getSharedPreferences(C.SHARE_PREF, 0).edit()
            edit.putString(key, value.toString())
            edit.apply()
        }

        @JvmOverloads
        fun getLong(context: Context, key: String, def: Long = 0): Long {
            return java.lang.Long.valueOf(context.applicationContext.getSharedPreferences(C.SHARE_PREF, 0).getString(key, def.toString())!!)
        }

        fun clearPref(context: Context) {
            context.applicationContext.getSharedPreferences(C.SHARE_PREF, 0).edit().clear().apply()
        }
    }
}