/*
	Milyn - Copyright (C) 2006 - 2010

	This library is free software; you can redistribute it and/or
	modify it under the terms of the GNU Lesser General Public
	License (version 2.1) as published by the Free Software
	Foundation.

	This library is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

	See the GNU Lesser General Public License for more details:
	http://www.gnu.org/licenses/lgpl.txt
*/
package org.milyn.smooks.edi.unedifact.model.r41.types;

import org.milyn.edisax.model.internal.DelimiterType;
import org.milyn.edisax.model.internal.Delimiters;
import org.milyn.edisax.util.EDIUtils;
import org.milyn.smooks.edi.EDIWritable;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Syntax Identifier.
 * 
 * @author <a href="mailto:tom.fennelly@gmail.com">tom.fennelly@gmail.com</a>
 */
public class SyntaxIdentifier extends Identifier implements Serializable, EDIWritable {

	private static final long serialVersionUID = 1L;

	private String serviceCodeListDirVersion;
	private String codedCharacterEncoding;

    public void write(Writer writer, Delimiters delimiters) throws IOException {
        Writer nodeWriter = new StringWriter();
        List<String> nodeTokens = new ArrayList<String>();

        if(getId() != null) {
            nodeWriter.write(delimiters.escape(getId()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getComponent());
        if(getVersionNum() != null) {
            nodeWriter.write(delimiters.escape(getVersionNum()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getComponent());
        if(serviceCodeListDirVersion != null) {
            nodeWriter.write(delimiters.escape(serviceCodeListDirVersion));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getComponent());
        if(codedCharacterEncoding != null) {
            nodeWriter.write(delimiters.escape(codedCharacterEncoding));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        nodeWriter.write(delimiters.getComponent());
        if(getReleaseNum() != null) {
            nodeWriter.write(delimiters.escape(getReleaseNum()));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }

        nodeTokens.add(nodeWriter.toString());
        writer.write(EDIUtils.concatAndTruncate(nodeTokens, DelimiterType.COMPONENT, delimiters));
    }

    public String getServiceCodeListDirVersion() {
		return serviceCodeListDirVersion;
	}
	public void setServiceCodeListDirVersion(String serviceCodeListDirVersion) {
		this.serviceCodeListDirVersion = serviceCodeListDirVersion;
	}
	public String getCodedCharacterEncoding() {
		return codedCharacterEncoding;
	}
	public void setCodedCharacterEncoding(String codedCharacterEncoding) {
		this.codedCharacterEncoding = codedCharacterEncoding;
	}
}
