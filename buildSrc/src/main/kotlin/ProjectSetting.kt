/**
 * Created by faisalamir on 19/09/21
 * FrogoRecyclerView
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.
 * All rights reserved
 *
 */

object ProjectSetting {

    const val NAME_APP = "Frogo SDK"

    const val APP_DOMAIN = "com"
    const val APP_PLAY_CONSOLE = "frogobox"
    const val APP_NAME = "appsdk"

    const val LIBRARY_NAME_CORE_SDK = "coresdk"
    const val LIBRARY_NAME_SDK = "sdk"
    const val LIBRARY_NAME_SDK_UTIL = "sdkutil"

    const val MODULE_NAME_CORE_SDK = "core-sdk"
    const val MODULE_NAME_SDK = "core-sdk-android"
    const val MODULE_NAME_SDK_UTIL = "core-sdk-android-util"

    const val LIBRARY_NAME_UI = "ui"
    const val MODULE_NAME_CORE_UI = "core-ui-android"

    const val LIBRARY_NAME_AD = "ad"
    const val LIBRARY_NAME_AD_CORE = "adcore"
    const val LIBRARY_NAME_ADMOB = "admob"
    const val LIBRARY_NAME_UNITY_AD = "unityad"
    const val LIBRARY_NAME_START_IO_AD = "startioad"

    const val MODULE_NAME_AD = "ad-general"
    const val MODULE_NAME_AD_CORE = "ad-core"
    const val MODULE_NAME_ADMOB = "ad-admob"
    const val MODULE_NAME_UNITY_AD = "ad-unityad"

    // ---------------------------------------------------------------------------------------------

    const val VERSION_MAJOR = 1
    const val VERSION_MINOR = 1
    const val VERSION_PATCH = 0

    // ---------------------------------------------------------------------------------------------

    const val PROJECT_MIN_SDK = 23
    const val PROJECT_COMPILE_SDK = 35
    const val PROJECT_TARGET_SDK = PROJECT_COMPILE_SDK

    // ---------------------------------------------------------------------------------------------

    val URI_PACKAGE_LIB = "https://maven.pkg.github.com/amirisback/frogo-admob"

    const val BASE_PACAKGE_NAME = "$APP_DOMAIN.$APP_PLAY_CONSOLE"

    const val PROJECT_NAME_SPACE = "$APP_DOMAIN.$APP_PLAY_CONSOLE"

    const val PROJECT_APP_ID = "$BASE_PACAKGE_NAME.deltadox"
    const val PROJECT_LIB_ID_SDK = "$BASE_PACAKGE_NAME.$LIBRARY_NAME_SDK"
    const val PROJECT_LIB_ID_CORE_SDK = "$BASE_PACAKGE_NAME.$LIBRARY_NAME_CORE_SDK"
    const val PROJECT_LIB_ID_SDK_UTIL = "$BASE_PACAKGE_NAME.$LIBRARY_NAME_SDK_UTIL"

    const val PROJECT_LIB_ID_UI = "$BASE_PACAKGE_NAME.$LIBRARY_NAME_UI"

    const val PROJECT_LIB_ID_AD = "$BASE_PACAKGE_NAME.$LIBRARY_NAME_AD"
    const val PROJECT_LIB_ID_ADMOB = "$BASE_PACAKGE_NAME.$LIBRARY_NAME_ADMOB"
    const val PROJECT_LIB_ID_AD_CORE = "$BASE_PACAKGE_NAME.$LIBRARY_NAME_AD_CORE"

    const val PROJECT_LIB_ID_UNITY_AD = "$BASE_PACAKGE_NAME.$LIBRARY_NAME_UNITY_AD"
    const val PROJECT_LIB_ID_START_IO_AD = "$BASE_PACAKGE_NAME.$LIBRARY_NAME_START_IO_AD"

    const val PROJECT_VERSION_CODE = (VERSION_MAJOR * 100) + (VERSION_MINOR * 10) + (VERSION_PATCH * 1)
    const val PROJECT_VERSION_NAME = "$VERSION_MAJOR.$VERSION_MINOR.$VERSION_PATCH"

    val NAME_APK = NAME_APP.lowercase().replace(" ", "-")

    val NAME_DB = NAME_APP.lowercase().replace(" ", "_")
    val DB = "\"$NAME_DB.db\""

    // ---------------------------------------------------------------------------------------------

    const val PLAYSTORE_STORE_FILE = "frogoboxmedia.jks"
    const val PLAYSTORE_STORE_PASSWORD = "amirisback"
    const val PLAYSTORE_KEY_ALIAS = "frogoisback"
    const val PLAYSTORE_KEY_PASSWORD = "amirisback"

}