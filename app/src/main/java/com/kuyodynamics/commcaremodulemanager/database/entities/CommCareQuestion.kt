package com.kuyodynamics.commcaremodulemanager.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

data class QuestionDataSource(
    var instanceId: String,
    var instanceRef: String,
    var labelRef: String,
    var nodeset: String,
    var valueRef: String
)

@Entity(
    tableName = "commcare_question", foreignKeys = [
        ForeignKey(
            entity = CommCareForm::class,
            parentColumns = ["formId"],
            childColumns = ["formId"],
            onDelete = CASCADE
        )
    ]
)
data class CommCareQuestion(

    @PrimaryKey()
    @ColumnInfo(name = "value")
    var value: String,

    @ColumnInfo(name = "form_id")
    var formId: String,

    @ColumnInfo(name = "constraint")
    var constraint: String,

    @ColumnInfo(name = "group")
    var group: String,

    @ColumnInfo(name = "hash_tag_value")
    var hashTagValue: String,

    @ColumnInfo(name = "is_group")
    var isGroup: Boolean,

    @ColumnInfo(name = "label")
    var label: String,

    @ColumnInfo(name = "label_ref")
    var labelRef: QuestionDataSource,

    @ColumnInfo(name = "repeat")
    var repeat: String,

    @ColumnInfo(name = "required")
    var required: Boolean,

    @ColumnInfo(name = "set_value")
    var setValue: String,

    @ColumnInfo(name = "tag")
    var tag: String,

    @ColumnInfo(name = "type")
    var type: String,

    @ColumnInfo(name = "data_source")
    var dataSource: String?
)
