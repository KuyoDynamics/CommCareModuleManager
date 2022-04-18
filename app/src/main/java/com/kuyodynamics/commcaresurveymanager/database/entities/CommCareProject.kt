package com.kuyodynamics.commcaresurveymanager.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kuyodynamics.commcaresurveymanager.domain.Project

@Entity(tableName = "commcare_project")
data class CommCareProject(

    @PrimaryKey
    @ColumnInfo(name = "domain_name")
    var domainName: String,

    @ColumnInfo(name = "project_name")
    var projectName: String
)

/**
 * [Extension Function] Map CommCareApps to domain entities
 */
fun List<CommCareProject>.asDomainModelList(): List<Project> {
    return map {
        Project(
            domainName = it.domainName,
            projectName = it.projectName
        )
    }
}