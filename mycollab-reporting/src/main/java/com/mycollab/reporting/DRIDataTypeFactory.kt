/**
 * Copyright © MyCollab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http:></http:>//www.gnu.org/licenses/>.
 */
package com.mycollab.reporting

import com.mycollab.core.reporting.NotInReport
import net.sf.dynamicreports.report.definition.datatype.DRIDataType
import net.sf.dynamicreports.report.exception.DRException

import java.lang.reflect.Field

import net.sf.dynamicreports.report.builder.DynamicReports.type

/**
 * @author MyCollab Ltd.
 * @since 1.0
 */
object DRIDataTypeFactory {

    @JvmStatic
    @Throws(DRException::class)
    fun <T : DRIDataType<*, *>> detectType(field: Field): T? {
        if (field.getAnnotation(NotInReport::class.java) != null) {
            return null
        }

        val dataType = field.type.name
        return type.detectType(dataType)
    }
}