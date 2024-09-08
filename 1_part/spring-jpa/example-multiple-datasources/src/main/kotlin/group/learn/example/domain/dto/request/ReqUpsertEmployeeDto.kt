package group.learn.example.domain.dto.request

import com.fasterxml.jackson.annotation.JsonInclude
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.util.UUID


data class ReqUpsertEmployeeDto (
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var id : UUID? = null,

    @field:NotNull(message = "name cannot be null")
    @field:NotBlank(message = "name cannot be blank")
    var name : String? = null,
    var supervisorId : UUID? = null,
    var departmentId : UUID? =null,
    var isActive : Boolean? = null,
)