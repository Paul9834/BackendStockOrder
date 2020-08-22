package com.paul9834.order.demo.exceptions

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class ExceptionResponse(val errorMessage: String,
                             val errorCode: String,
                             @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
                             val localDateTime: LocalDateTime
)
