package com.cihadgokce.wallet.core.constant

object GlobalConstant {
    const val BASE_URL = "https://api.example.org/" // deneme api
    const val READ_TIMEOUT = 30
    const val WRITE_TIMEOUT = 30
    const val CONNECTION_TIMEOUT = 10
    const val CACHE_SIZE_BYTES = 10 * 1024 * 1024L
    const val FAKE_RESPONSE = "" +
            "[ \n" +
            " { \n" +
            " \"image\": \"https://dummyimage.com/450x300/5db185/18163d.png&text=INVENTIV\",  \"number\": \"1234567812345678\", \n" +
            " \"cvv\": \"123\", \n" +
            " \"balance\": { \n" +
            " \"value\": \"292750\", \n" +
            " \"currency\": \"TL\" \n" +
            " }, \n" +
            " \"pendingBalance\": { \n" +
            " \"value\": \"50000\", \n" +
            " \"currency\": \"TL\" \n" +
            " } \n" +
            " }, \n" +
            " { \n" +
            " \"image\": \"https://dummyimage.com/450x300/5db185/18163d.png&text=INVENTIV-2\",  \"number\": \"1234123412341234\", \n" +
            " \"cvv\": \"321\", \n" +
            " \"balance\": { \n" +
            " \"value\": \"400050\", \n" +
            " \"currency\": \"TL\" \n" +
            " }, \n" +
            " \"pendingBalance\": { \n" +
            " \"value\": \"40000\", \n" +
            " \"currency\": \"TL\" \n" +
            " } \n" +
            " } \n" +
            "]\n"
}