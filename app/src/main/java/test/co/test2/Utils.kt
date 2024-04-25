package test.co.test2

import java.util.*

val localeID = Locale("in", "ID")
val localeEn = Locale.ENGLISH

object C {
    const val LANGUAGE_TYPE = "languageType"
    const val SHARE_PREF: String = "SHARE_PREFERENCES"
}

fun String.convertToCurrencyFormat(prefix: String, lang: String?): String {
    if (lang.equals("en")){
        if (prefix.equals("")) {
            val double = this.toDoubleOrNull() ?: return this
            return String.format(localeEn, "%,.0f", double)
        } else {
            val double = this.toDoubleOrNull() ?: return this
            return prefix + " " + String.format(localeEn, "%,.0f", double)
        }
    } else {
        if (prefix.equals("")) {
            val double = this.toDoubleOrNull() ?: return this
            return String.format(localeID, "%,.0f", double)
        } else {
            val double = this.toDoubleOrNull() ?: return this
            return prefix + " " + String.format(localeID, "%,.0f", double)
        }
    }
}