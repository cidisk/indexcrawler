/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.cidisk.indexcrawler.parser;

import io.github.cidisk.indexcrawler.url.WebURL;

import java.util.HashSet;
import java.util.Set;

public class TextParseData implements ParseData {

	private String textContent;
	private Set<WebURL> outgoingIndexUrls = new HashSet<>();
	private Set<WebURL> infoUrls = new HashSet<>();

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}
	@Override
	public Set<WebURL> getInfoUrls() {
		return infoUrls;
	}
	@Override
	public void setInfoUrls(Set<WebURL> infoUrls) {
		this.infoUrls = infoUrls;
	}
	@Override
	public Set<WebURL> getOutgoingIndexUrls() {
		return outgoingIndexUrls;
	}
	@Override
	public void setOutgoingIndexUrls(Set<WebURL> outgoingIndexUrls) {
		this.outgoingIndexUrls = outgoingIndexUrls;
	}

	/*@Override
	public Set<WebURL> getOutgoingUrls() {
		return getOutgoingIndexUrls();
	}

	@Override
	public void setOutgoingUrls(Set<WebURL> outgoingUrls) {
		setOutgoingIndexUrls(outgoingUrls);
	}*/

	@Override
	public String toString() {
		return textContent;
	}
}