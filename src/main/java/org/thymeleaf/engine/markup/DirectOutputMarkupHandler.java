/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2014, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.engine.markup;

import java.io.IOException;
import java.io.Writer;

import org.thymeleaf.exceptions.TemplateOutputException;

/**
 *
 * @author Daniel Fern&aacute;ndez
 * @since 3.0.0
 *
 */
public class DirectOutputMarkupHandler extends AbstractMarkupHandler {


    private final String documentName;
    private final Writer writer;


    public DirectOutputMarkupHandler(final String documentName, final Writer writer) {
        super();
        this.documentName = documentName;
        this.writer = writer;
    }





    /*
     * ---------------
     * Document events
     * ---------------
     */

    @Override
    public void onDocumentStart(
            final long startTimeNanos) {

        // Nothing to be done here

    }



    @Override
    public void onDocumentEnd(
            final long endTimeNanos, final long totalTimeNanos) {

        // Nothing to be done here

    }





    /*
     * ------------------------
     * XML Declaration events
     * ------------------------
     */

    @Override
    public void onXmlDeclaration (
            final String xmlDeclaration,
            final String version, final String encoding, final boolean standalone,
            final int line, final int col) {

        try {
            this.writer.write(xmlDeclaration);
        } catch (final IOException e) {
            throw new TemplateOutputException(
                    String.format("Error trying to write output for template \"{}\"", documentName), e);
        }

    }





    /*
     * ---------------------
     * DOCTYPE Clause events
     * ---------------------
     */

    @Override
    public void onDocTypeClause (
            final String docTypeClause,
            final String rootElementName, final String publicId, final String systemId,
            final int line, final int col) {

        try {
            this.writer.write(docTypeClause);
        } catch (final IOException e) {
            throw new TemplateOutputException(
                    String.format("Error trying to write output for template \"{}\"", documentName), e);
        }

    }





    /*
     * --------------------
     * CDATA Section events
     * --------------------
     */

    @Override
    public void onCDATASection (
            final char[] buffer, final int offset, final int len,
            final int line, final int col) {

        try {
            this.writer.write("<![CDATA[");
            this.writer.write(buffer, offset, len);
            this.writer.write("]]>");
        } catch (final IOException e) {
            throw new TemplateOutputException(
                    String.format("Error trying to write output for template \"{}\"", documentName), e);
        }

    }





    /*
     * -----------
     * Text events
     * -----------
     */

    @Override
    public void onText (
            final char[] buffer, final int offset, final int len,
            final int line, final int col) {

        try {
            this.writer.write(buffer, offset, len);
        } catch (final IOException e) {
            throw new TemplateOutputException(
                    String.format("Error trying to write output for template \"{}\"", documentName), e);
        }

    }





    /*
     * --------------
     * Comment events
     * --------------
     */

    @Override
    public void onComment (
            final char[] buffer, final int offset, final int len,
            final int line, final int col) {

        try {
            this.writer.write("<!--");
            this.writer.write(buffer, offset, len);
            this.writer.write("-->");
        } catch (final IOException e) {
            throw new TemplateOutputException(
                    String.format("Error trying to write output for template \"{}\"", documentName), e);
        }

    }





    /*
     * ----------------
     * Element handling
     * ----------------
     */

    @Override
    public void onAttribute (
            final char[] buffer,
            final int nameOffset, final int nameLen,
            final int nameLine, final int nameCol,
            final int operatorOffset, final int operatorLen,
            final int operatorLine, final int operatorCol,
            final int valueContentOffset, final int valueContentLen,
            final int valueOuterOffset, final int valueOuterLen,
            final int valueLine, final int valueCol) {

    try {
            this.writer.write(buffer, nameOffset, nameLen);
            this.writer.write(buffer, operatorOffset, operatorLen);
            this.writer.write(buffer, valueOuterOffset, valueOuterLen);
        } catch (final IOException e) {
            throw new TemplateOutputException(
                    String.format("Error trying to write output for template \"{}\"", documentName), e);
        }

    }


    @Override
    public void onStandaloneElementStart(
            final char[] buffer, final int offset, final int len, final String normalizedName,
            final int line, final int col) {

        try {
            this.writer.write("<");
            this.writer.write(buffer, offset, len);
        } catch (final IOException e) {
            throw new TemplateOutputException(
                    String.format("Error trying to write output for template \"{}\"", documentName), e);
        }

    }


    @Override
    public void onStandaloneElementEnd (
            final char[] buffer, final int offset, final int len, final String normalizedName,
            final int line, final int col) {

        try {
            this.writer.write("/>");
        } catch (final IOException e) {
            throw new TemplateOutputException(
                    String.format("Error trying to write output for template \"{}\"", documentName), e);
        }

    }


    @Override
    public void onOpenElementStart (
            final char[] buffer, final int offset, final int len, final String normalizedName,
            final int line, final int col) {

        try {
            this.writer.write("<");
            this.writer.write(buffer, offset, len);
        } catch (final IOException e) {
            throw new TemplateOutputException(
                    String.format("Error trying to write output for template \"{}\"", documentName), e);
        }

    }


    @Override
    public void onOpenElementEnd (
            final char[] buffer, final int offset, final int len, final String normalizedName,
            final int line, final int col) {

        try {
            this.writer.write(">");
        } catch (final IOException e) {
            throw new TemplateOutputException(
                    String.format("Error trying to write output for template \"{}\"", documentName), e);
        }

    }


    @Override
    public void onCloseElementStart (
            final char[] buffer, final int offset, final int len, final String normalizedName,
            final int line, final int col) {

        try {
            this.writer.write("</");
            this.writer.write(buffer, offset, len);
        } catch (final IOException e) {
            throw new TemplateOutputException(
                    String.format("Error trying to write output for template \"{}\"", documentName), e);
        }

    }


    @Override
    public void onCloseElementEnd (
            final char[] buffer, final int offset, final int len, final String normalizedName,
            final int line, final int col) {

        try {
            this.writer.write(">");
        } catch (final IOException e) {
            throw new TemplateOutputException(
                    String.format("Error trying to write output for template \"{}\"", documentName), e);
        }

    }


    @Override
    public void onAutoCloseElementStart (
            final char[] buffer, final int offset, final int len, final String normalizedName,
            final int line, final int col) {

        // Nothing to be done here. This event is ignored in output

    }


    @Override
    public void onAutoCloseElementEnd (
            final char[] buffer, final int offset, final int len, final String normalizedName,
            final int line, final int col) {

        // Nothing to be done here. This event is ignored in output

    }


    @Override
    public void onUnmatchedCloseElementStart (
            final char[] buffer, final int offset, final int len, final String normalizedName,
            final int line, final int col) {

        // Nothing to be done here. This event is ignored in output

    }


    @Override
    public void onUnmatchedCloseElementEnd (
            final char[] buffer, final int offset, final int len, final String normalizedName,
            final int line, final int col) {

        // Nothing to be done here. This event is ignored in output

    }




    @Override
    public void onElementInnerWhiteSpace (
            final char[] buffer, final int offset, final int len,
            final int line, final int col) {

        try {
            this.writer.write(buffer, offset, len);
        } catch (final IOException e) {
            throw new TemplateOutputException(
                    String.format("Error trying to write output for template \"{}\"", documentName), e);
        }

    }





    /*
     * -------------------------------
     * Processing Instruction handling
     * -------------------------------
     */

    @Override
    public void onProcessingInstruction (
            final String processingInstruction,
            final String target, final String content,
            final int line, final int col) {

        try {
            this.writer.write(processingInstruction);
        } catch (final IOException e) {
            throw new TemplateOutputException(
                    String.format("Error trying to write output for template \"{}\"", documentName), e);
        }

    }




}