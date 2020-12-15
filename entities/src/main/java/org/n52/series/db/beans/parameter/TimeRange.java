/*
 * Copyright 2015-2020 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.series.db.beans.parameter;

import java.util.Date;

import org.n52.series.db.common.Utils;

public class TimeRange {

    private Date from;

    private Date to;

    public TimeRange() {
        this(null);
    }

    public TimeRange(Date time) {
        this(time, time);
    }

    public TimeRange(Date from, Date to) {
        setFrom(from);
        setTo(to);
    }

    public Date getFrom() {
        return Utils.createUnmutableTimestamp(from);
    }

    public void setFrom(Date from) {
        this.from = Utils.createUnmutableTimestamp(from);
    }

    public boolean isSetFrom() {
        return getFrom() != null;
    }

    public Date getTo() {
        return Utils.createUnmutableTimestamp(to);
    }

    public void setTo(Date to) {
        this.to = Utils.createUnmutableTimestamp(to);
    }

    public boolean isSetTo() {
        return getTo() != null;
    }

    public Date getInstant() {
        return isSetFrom() ? getFrom() : getTo();
    }

    public boolean isInstant() {
        return !isPeriod() && (isSetFrom() || isSetTo());
    }

    public boolean isPeriod() {
        return isSetFrom() && isSetTo() && !getFrom().equals(getTo());
    }
}