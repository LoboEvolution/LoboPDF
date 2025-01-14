/*
 * MIT License
 *
 * Copyright (c) 2014 - 2023 LoboEvolution
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * Contact info: ivan.difrancesco@yahoo.it
 */

package org.loboevolution.pdfview.font.ttf;

import java.nio.ByteBuffer;

/**
 * <p>MaxpTable class.</p>
 * <p>
 * Author  jkaplan
 */
public class MaxpTable extends TrueTypeTable {

    /**
     * Holds value of property version.
     */
    private int version;

    // the following are supposed to be USHORT, but will be Int to enclose the sign
    // (http://www.microsoft.com/typography/OTSpec/maxp.htm)
    /**
     * Holds value of property numGlyphs.
     */
    private int numGlyphs;

    /**
     * Holds value of property maxPoints.
     */
    private int maxPoints;

    /**
     * Holds value of property maxContours.
     */
    private int maxContours;

    /**
     * Holds value of property maxComponentPoints.
     */
    private int maxComponentPoints;

    /**
     * Holds value of property maxComponentContours.
     */
    private int maxComponentContours;

    /**
     * Holds value of property maxZones.
     */
    private int maxZones;

    /**
     * Holds value of property maxTwilightPoints.
     */
    private int maxTwilightPoints;

    /**
     * Holds value of property maxStorage.
     */
    private int maxStorage;

    /**
     * Holds value of property maxFunctionDefs.
     */
    private int maxFunctionDefs;

    /**
     * Holds value of property maxInstructionDefs.
     */
    private int maxInstructionDefs;

    /**
     * Holds value of property maxStackElements.
     */
    private int maxStackElements;

    /**
     * Holds value of property maxSizeOfInstructions.
     */
    private int maxSizeOfInstructions;

    /**
     * Holds value of property maxComponentElements.
     */
    private int maxComponentElements;

    /**
     * Holds value of property maxComponentDepth.
     */
    private int maxComponentDepth;

    /**
     * Creates a new instance of MaxpTable
     */
    protected MaxpTable() {
        super(TrueTypeTable.MAXP_TABLE);

        setVersion(0x10000);
        setNumGlyphs(0);
        setMaxPoints(0);
        setMaxContours(0);
        setMaxComponentPoints(0);
        setMaxComponentContours(0);
        setMaxZones(2);
        setMaxTwilightPoints(0);
        setMaxStorage(0);
        setMaxFunctionDefs(0);
        setMaxInstructionDefs(0);
        setMaxStackElements(0);
        setMaxSizeOfInstructions(0);
        setMaxComponentElements(0);
        setMaxComponentDepth(0);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Get a buffer from the data
     */
    @Override
    public ByteBuffer getData() {
        final ByteBuffer buf = ByteBuffer.allocate(getLength());

        buf.putInt(getVersion());
        buf.putShort((short) getNumGlyphs());
        buf.putShort((short) getMaxPoints());
        buf.putShort((short) getMaxContours());
        buf.putShort((short) getMaxComponentPoints());
        buf.putShort((short) getMaxComponentContours());
        buf.putShort((short) getMaxZones());
        buf.putShort((short) getMaxTwilightPoints());
        buf.putShort((short) getMaxStorage());
        buf.putShort((short) getMaxFunctionDefs());
        buf.putShort((short) getMaxInstructionDefs());
        buf.putShort((short) getMaxStackElements());
        buf.putShort((short) getMaxSizeOfInstructions());
        buf.putShort((short) getMaxComponentElements());
        buf.putShort((short) getMaxComponentDepth());

        // reset the position to the beginning of the buffer
        buf.flip();

        return buf;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Set the values from data
     */
    @Override
    public void setData(final ByteBuffer data) {
        if (data.remaining() != 32) {
            throw new IllegalArgumentException("Bad size for Maxp table");
        }

        setVersion(data.getInt());
        setNumGlyphs(data.getShort());
        setMaxPoints(data.getShort());
        setMaxContours(data.getShort());
        setMaxComponentPoints(data.getShort());
        setMaxComponentContours(data.getShort());
        setMaxZones(data.getShort());
        setMaxTwilightPoints(data.getShort());
        setMaxStorage(data.getShort());
        setMaxFunctionDefs(data.getShort());
        setMaxInstructionDefs(data.getShort());
        setMaxStackElements(data.getShort());
        setMaxSizeOfInstructions(data.getShort());
        setMaxComponentElements(data.getShort());
        setMaxComponentDepth(data.getShort());
    }

    /**
     * {@inheritDoc}
     * <p>
     * Get the length of this table
     */
    @Override
    public int getLength() {
        return 32;
    }

    /**
     * Getter for property version.
     *
     * @return Value of property version.
     */
    public int getVersion() {
        return this.version;
    }

    /**
     * Setter for property version.
     *
     * @param version New value of property version.
     */
    public void setVersion(final int version) {
        this.version = version;
    }

    /**
     * Getter for property numGlyphs.
     *
     * @return Value of property numGlyphs.
     */
    public int getNumGlyphs() {
        return this.numGlyphs & 0xFFFF;
    }

    /**
     * Setter for property numGlyphs.
     *
     * @param numGlyphs New value of property numGlyphs.
     */
    public void setNumGlyphs(final int numGlyphs) {
        this.numGlyphs = numGlyphs;
    }

    /**
     * Getter for property maxPoints.
     *
     * @return Value of property maxPoints.
     */
    public int getMaxPoints() {
        return this.maxPoints & 0xFFFF;
    }

    /**
     * Setter for property maxPoints.
     *
     * @param maxPoints New value of property maxPoints.
     */
    public void setMaxPoints(final int maxPoints) {
        this.maxPoints = maxPoints;
    }

    /**
     * Getter for property maxContours.
     *
     * @return Value of property maxContours.
     */
    public int getMaxContours() {
        return this.maxContours & 0xFFFF;
    }

    /**
     * Setter for property maxContours.
     *
     * @param maxContours New value of property maxContours.
     */
    public void setMaxContours(final int maxContours) {
        this.maxContours = maxContours;
    }

    /**
     * Getter for property maxComponentPoints.
     *
     * @return Value of property maxComponentPoints.
     */
    public int getMaxComponentPoints() {
        return this.maxComponentPoints & 0xFFFF;
    }

    /**
     * Setter for property maxComponentPoints.
     *
     * @param maxComponentPoints New value of property maxComponentPoints.
     */
    public void setMaxComponentPoints(final int maxComponentPoints) {
        this.maxComponentPoints = maxComponentPoints;
    }

    /**
     * Getter for property maxComponentContours.
     *
     * @return Value of property maxComponentContours.
     */
    public int getMaxComponentContours() {
        return this.maxComponentContours & 0xFFFF;
    }

    /**
     * Setter for property maxComponentContours.
     *
     * @param maxComponentContours New value of property maxComponentContours.
     */
    public void setMaxComponentContours(final int maxComponentContours) {
        this.maxComponentContours = maxComponentContours;
    }

    /**
     * Getter for property maxZones.
     *
     * @return Value of property maxZones.
     */
    public int getMaxZones() {
        return this.maxZones & 0xFFFF;
    }

    /**
     * Setter for property maxZones.
     *
     * @param maxZones New value of property maxZones.
     */
    public void setMaxZones(final int maxZones) {
        this.maxZones = maxZones;
    }

    /**
     * Getter for property maxTwilightPoints.
     *
     * @return Value of property maxTwilightPoints.
     */
    public int getMaxTwilightPoints() {
        return this.maxTwilightPoints & 0xFFFF;
    }

    /**
     * Setter for property maxTwilightPoints.
     *
     * @param maxTwilightPoints New value of property maxTwilightPoints.
     */
    public void setMaxTwilightPoints(final int maxTwilightPoints) {
        this.maxTwilightPoints = maxTwilightPoints;
    }

    /**
     * Getter for property maxStorage.
     *
     * @return Value of property maxStorage.
     */
    public int getMaxStorage() {
        return this.maxStorage & 0xFFFF;
    }

    /**
     * Setter for property maxStorage.
     *
     * @param maxStorage New value of property maxStorage.
     */
    public void setMaxStorage(final int maxStorage) {
        this.maxStorage = maxStorage;
    }

    /**
     * Getter for property maxFunctionDefs.
     *
     * @return Value of property maxFunctionDefs.
     */
    public int getMaxFunctionDefs() {
        return this.maxFunctionDefs & 0xFFFF;
    }

    /**
     * Setter for property maxFunctionDefs.
     *
     * @param maxFunctionDefs New value of property maxFunctionDefs.
     */
    public void setMaxFunctionDefs(final int maxFunctionDefs) {
        this.maxFunctionDefs = maxFunctionDefs;
    }

    /**
     * Getter for property maxInstructionDefs.
     *
     * @return Value of property maxInstructionDefs.
     */
    public int getMaxInstructionDefs() {
        return this.maxInstructionDefs & 0xFFFF;
    }

    /**
     * Setter for property maxInstructionDefs.
     *
     * @param maxInstructionDefs New value of property maxInstructionDefs.
     */
    public void setMaxInstructionDefs(final int maxInstructionDefs) {
        this.maxInstructionDefs = maxInstructionDefs;
    }

    /**
     * Getter for property maxStackElements.
     *
     * @return Value of property maxStackElements.
     */
    public int getMaxStackElements() {
        return this.maxStackElements & 0xFFFF;
    }

    /**
     * Setter for property maxStackElements.
     *
     * @param maxStackElements New value of property maxStackElements.
     */
    public void setMaxStackElements(final int maxStackElements) {
        this.maxStackElements = maxStackElements;
    }

    /**
     * Getter for property maxSizeOfInstructions.
     *
     * @return Value of property maxSizeOfInstructions.
     */
    public int getMaxSizeOfInstructions() {
        return this.maxSizeOfInstructions & 0xFFFF;
    }

    /**
     * Setter for property maxSizeOfInstructions.
     *
     * @param maxSizeOfInstructions New value of property maxSizeOfInstructions.
     */
    public void setMaxSizeOfInstructions(final int maxSizeOfInstructions) {
        this.maxSizeOfInstructions = maxSizeOfInstructions;
    }

    /**
     * Getter for property maxComponentElements.
     *
     * @return Value of property maxComponentElements.
     */
    public int getMaxComponentElements() {
        return this.maxComponentElements & 0xFFFF;
    }

    /**
     * Setter for property maxComponentElements.
     *
     * @param maxComponentElements New value of property maxComponentElements.
     */
    public void setMaxComponentElements(final int maxComponentElements) {
        this.maxComponentElements = maxComponentElements;
    }

    /**
     * Getter for property maxComponentDepth.
     *
     * @return Value of property maxComponentDepth.
     */
    public int getMaxComponentDepth() {
        return this.maxComponentDepth & 0xFFFF;
    }

    /**
     * Setter for property maxComponentDepth.
     *
     * @param maxComponentDepth New value of property maxComponentDepth.
     */
    public void setMaxComponentDepth(final int maxComponentDepth) {
        this.maxComponentDepth = maxComponentDepth;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Create a pretty String
     */
    @Override
    public String toString() {
        final StringBuilder buf = new StringBuilder();
        final String indent = "    ";

        buf.append(indent).append("Version          : ").append(Integer.toHexString(getVersion())).append("\n");
        buf.append(indent).append("NumGlyphs        : ").append(getNumGlyphs()).append("\n");
        buf.append(indent).append("MaxPoints        : ").append(getMaxPoints()).append("\n");
        buf.append(indent).append("MaxContours      : ").append(getMaxContours()).append("\n");
        buf.append(indent).append("MaxCompPoints    : ").append(getMaxComponentPoints()).append("\n");
        buf.append(indent).append("MaxCompContours  : ").append(getMaxComponentContours()).append("\n");
        buf.append(indent).append("MaxZones         : ").append(getMaxZones()).append("\n");
        buf.append(indent).append("MaxTwilightPoints: ").append(getMaxTwilightPoints()).append("\n");
        buf.append(indent).append("MaxStorage       : ").append(getMaxStorage()).append("\n");
        buf.append(indent).append("MaxFuncDefs      : ").append(getMaxFunctionDefs()).append("\n");
        buf.append(indent).append("MaxInstDefs      : ").append(getMaxInstructionDefs()).append("\n");
        buf.append(indent).append("MaxStackElements : ").append(getMaxStackElements()).append("\n");
        buf.append(indent).append("MaxSizeInst      : ").append(getMaxSizeOfInstructions()).append("\n");
        buf.append(indent).append("MaxCompElements  : ").append(getMaxComponentElements()).append("\n");
        buf.append(indent).append("MaxCompDepth     : ").append(getMaxComponentDepth()).append("\n");

        return buf.toString();
    }
}
