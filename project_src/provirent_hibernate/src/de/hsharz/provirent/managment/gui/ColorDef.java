/*
 * Created on 23.10.2004
 *
 * Copyright (c) 2004/2005, Remo Griesch/Stefan Forstner/Philipp Schneider
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * - Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * - Neither the name of the Remo Griesch/Stefan Forstner/Philipp Schneider nor
 * the names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 */
package de.hsharz.provirent.managment.gui;

import org.eclipse.swt.graphics.Color;

import com.cloudgarden.resource.SWTResourceManager;

/**
 * @author Philipp Schneider
 *
 */
public class ColorDef {
    
    public static final Color STANDARD = SWTResourceManager.getColor(
            212,
            208,
            200);

    
    
    
    public static final Color STATUS_B_STANDARD = SWTResourceManager.getColor(
            204,
            200,
            194);
    

    public static final Color STATUS_F_STANDARD = SWTResourceManager.getColor(
            0,
            0,
            0);
    
    
   
    public static final Color STATUS_B_INFO = SWTResourceManager.getColor(
            255,
            255,
            255);

    
    public static final Color STATUS_F_INFO = SWTResourceManager.getColor(
            255,
            247,
            194);

    
    public static final Color STATUS_B_WARN = SWTResourceManager.getColor(
            255,
            207,
            188);

    
    public static final Color STATUS_F_WARN = SWTResourceManager.getColor(
            255,
            255,
            255);

    public static final Color STATUS_B_ERROR = SWTResourceManager.getColor(
            255,
            0,
            0);

    
    public static final Color STATUS_F_ERROR = SWTResourceManager.getColor(
            255,
            255,
            255);    
}
