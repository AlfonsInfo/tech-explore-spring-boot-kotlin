package group.learn.multidatasource.service.department

import group.learn.multidatasource.domain.dto.response.ResAllDepartmentDto
import group.learn.multidatasource.domain.dto.response.ResListDepartmentDto
import group.learn.multidatasource.domain.entity.global.DepartmentEntity
import org.springframework.data.domain.Page

class DepartmentMappingService {
    companion object{
        fun mapIntoResGetAllDepartment(listDepartment : List<DepartmentEntity>) : List<ResAllDepartmentDto>{
            return listDepartment.map { ResAllDepartmentDto(id = it.name, name = it.name) }
        }


        fun mapIntoResGetListDepartment(pageDepartmentEntity : Page<DepartmentEntity>) : List<ResListDepartmentDto>{
            return  pageDepartmentEntity.content.map { ResListDepartmentDto(id = it.id.toString(), name = it.name, isActive = it.flagActive)}
        }


    }
}