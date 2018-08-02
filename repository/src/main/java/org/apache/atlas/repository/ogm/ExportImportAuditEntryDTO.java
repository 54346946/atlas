/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.atlas.repository.ogm;

import org.apache.atlas.exception.AtlasBaseException;
import org.apache.atlas.model.instance.AtlasEntity;
import org.apache.atlas.model.impexp.ExportImportAuditEntry;
import org.apache.atlas.type.AtlasTypeRegistry;

import java.util.Map;

public class ExportImportAuditEntryDTO extends AbstractDataTransferObject<ExportImportAuditEntry> {

    public static final String PROPERTY_USER_NAME              = "userName";
    public static final String PROPERTY_OPERATION              = "operation";
    public static final String PROPERTY_OPERATION_PARAMS       = "operationParams";
    public static final String PROPERTY_START_TIME             = "operationStartTime";
    public static final String PROPERTY_END_TIME               = "operationEndTime";
    public static final String PROPERTY_RESULT_SUMMARY         = "resultSummary";
    public static final String PROPERTY_SOURCE_CLUSTER_NAME    = "sourceClusterName";
    public static final String PROPERTY_TARGET_CLUSTER_NAME    = "targetClusterName";

    protected ExportImportAuditEntryDTO(AtlasTypeRegistry typeRegistry) {
        super(typeRegistry, ExportImportAuditEntry.class);
    }

    @Override
    public ExportImportAuditEntry from(AtlasEntity entity) {
        ExportImportAuditEntry entry = new ExportImportAuditEntry();

        setGuid(entry, entity);
        entry.setUserName((String) entity.getAttribute(PROPERTY_USER_NAME));
        entry.setOperation((String) entity.getAttribute(PROPERTY_OPERATION));
        entry.setOperationParams((String) entity.getAttribute(PROPERTY_OPERATION_PARAMS));
        entry.setStartTime((long) entity.getAttribute(PROPERTY_START_TIME));
        entry.setEndTime((long) entity.getAttribute(PROPERTY_END_TIME));
        entry.setSourceClusterName((String) entity.getAttribute(PROPERTY_SOURCE_CLUSTER_NAME));
        entry.setTargetClusterName((String) entity.getAttribute(PROPERTY_TARGET_CLUSTER_NAME));
        entry.setResultSummary((String) entity.getAttribute(PROPERTY_RESULT_SUMMARY));

        return entry;
    }

    @Override
    public ExportImportAuditEntry from(AtlasEntity.AtlasEntityWithExtInfo entityWithExtInfo) {
        return from(entityWithExtInfo.getEntity());
    }

    @Override
    public AtlasEntity toEntity(ExportImportAuditEntry obj) {
        AtlasEntity entity = getDefaultAtlasEntity(obj);

        entity.setAttribute(PROPERTY_USER_NAME, obj.getUserName());
        entity.setAttribute(PROPERTY_OPERATION, obj.getOperation());
        entity.setAttribute(PROPERTY_OPERATION_PARAMS, obj.getOperationParams());
        entity.setAttribute(PROPERTY_START_TIME, obj.getStartTime());
        entity.setAttribute(PROPERTY_END_TIME, obj.getEndTime());
        entity.setAttribute(PROPERTY_SOURCE_CLUSTER_NAME, obj.getSourceClusterName());
        entity.setAttribute(PROPERTY_TARGET_CLUSTER_NAME, obj.getTargetClusterName());
        entity.setAttribute(PROPERTY_RESULT_SUMMARY, obj.getResultSummary());

        return entity;
    }

    @Override
    public AtlasEntity.AtlasEntityWithExtInfo toEntityWithExtInfo(ExportImportAuditEntry obj) throws AtlasBaseException {
        return new AtlasEntity.AtlasEntityWithExtInfo(toEntity(obj));
    }

    @Override
    public Map<String, Object> getUniqueAttributes(final ExportImportAuditEntry obj) {
        return null;
    }
}
