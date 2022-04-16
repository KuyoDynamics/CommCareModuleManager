package com.kuyodynamics.commcaresurveymanager.network

/**
 * DataTransferObjects go in this file. These are responsible for parsing responses from the server
 * or formatting objects to send to the server. You should convert these to domain objects before
 * using them.
 *
 * @see domain package for
 */

/**
 * AppsHolder holds a list of Apps.
 *
 * This is a parse first level of our network result which looks like
 *
 * {
 *      "meta": {},
 *      "objects": [
 *          {
 *              "id": "some_id",
 *              ...,
 *              "modules": []
 *          }
 *      ]
 * }
 *
 * But I just want to return a list of Apps that look like {id: "some_id", name: "some_app_name"}
 */
data class DataTransferObjects(val a: Int = 2){}
