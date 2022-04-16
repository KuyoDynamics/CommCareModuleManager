package com.kuyodynamics.commcaresurveymanager.domain

import java.util.*

/**
 * Domain objects are plain Kotlin data classes that represent the things in our app. These are the
 * objects that should be displayed on screen, or manipulated by the app.
 *
 * @see database for objects that are mapped to the database
 * @see network for objects that parse or prepare network calls
 */

/**
 * CommCareApps represent a CommCare App that can be displayed.
 */
data class App(
    var appId: String,

    var name: String,

    var buildComment: String,

    var builtOn: Date,

    var isReleased: Boolean,

    var version: Int
)