/*
 * Created on 25.10.2004
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

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

/**
 * @author Philipp Schneider
 *
 */
public class StatusLineStyledText extends StyledText {

    private static final int SLEEP_TIME = 5;
    
    
    
    public void setStatus(final int mode, final String message) {
        /**
         * mode values 0 normal message 1 information message 2 warn message 3
         * error message
         *  
         */
        if (mode == 0) {
            this.setBackground(ColorDef.STATUS_B_STANDARD);
            this.setForeground(ColorDef.STATUS_F_STANDARD);
        } else if (mode == 1) {
            this.setBackground(ColorDef.STATUS_B_INFO);
            this.setForeground(ColorDef.STATUS_F_INFO);
        } else if (mode == 2) {
            this.setBackground(ColorDef.STATUS_B_WARN);
            this.setForeground(ColorDef.STATUS_F_WARN);
        } else if (mode == 3) {
            this.setBackground(ColorDef.STATUS_B_ERROR);
            this.setForeground(ColorDef.STATUS_F_ERROR);
        }

        this.setText(message);

		new Thread() {
			public void run() {
				
				try {Thread.sleep (1000 * SLEEP_TIME);} catch (Throwable th) {}
					if (Display.getDefault().isDisposed()) return;
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
						    setBackground(ColorDef.STATUS_B_STANDARD);
						    setForeground(ColorDef.STATUS_F_STANDARD);
						}
					});
				
			}
		}.start();

    }    
    
    /**
     * @param parent
     * @param style
     */
    public StatusLineStyledText(Composite parent, int style) {
        super(parent, style);
        // TODO Auto-generated constructor stub
    }

}
