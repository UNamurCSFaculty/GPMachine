/*
This is "gpmachine" a PCode interpreter, by Yiti Group, rewritten by Yves Bontemps
Copyright (C) 2002-2004  Yves Bontemps
Copyright (C) 2006 Khvalenski Andrew
Copyright (C) 2004-2008 Hubert Toussaint
 
This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.
 
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
 
You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 
Contact:
 Hubert Toussaint
 CS Dept - University of Namur
 rue Grandgagnage, 21
 B5000 Namur
 Belgium
 gpm@info.fundp.ac.be
 */

/**
 * @author ybo
 *
 * TODO Comment this class
 */

package pmachine.instructions;

import pmachine.Messages;
import pmachine.PMachine;
import pmachine.StackElem;
import pmachine.StackElemAddr;
import pmachine.StackElemPCAddr;
import pmachine.exceptions.RuntimeException;
import pmachine.exceptions.WrongTypeException;

public class PInstructionRETF extends PInstructionAbstract {

	/*
	 * (non-Javadoc)
	 * 
	 * @see pmachine.instructions.PInstructionAbstract#getName()
	 */
	public String getName() {
		return "retf";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pmachine.instructions.PInstructionAbstract#getArgs()
	 */
	public String getArgs() {
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pmachine.instructions.PInstruction#execute(pmachine.PMachine)
	 */
	public void execute(PMachine pm) throws RuntimeException {
		StackElem ret = pm.getPMemory().elemAt(pm.getMP() + 4); // return
																// address
		StackElem a = pm.getPMemory().elemAt(pm.getMP() + 2); // dynamic
																// predecessor

		// Kill the function's stack space
		// but keep the function result on top of stack
		pm.setSP(pm.getMP());

		// reinitialize MP and jump back to call PC address
		if (a instanceof StackElemAddr && ret instanceof StackElemPCAddr) {
			pm.setMP((int) ((StackElemAddr) a).intValue());
			pm.jumpToAddress((StackElemPCAddr) ret);
		} else {
			throw new WrongTypeException(Messages
					.getString("PMachine.RETF_TypeError"));
		}
	}

}
