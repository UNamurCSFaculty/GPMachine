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

import java.io.FileNotFoundException;
import java.io.IOException;

import pmachine.exceptions.RuntimeException;

/**
 * 
 * This class is the entry point for the application. This class contains only
 * one method, "main", which delegates to pmachine.PMachine.main(String[]).
 * 
 * @see pmachine.PMachine.main
 * 
 * @author ybo
 */
public class MainClass {

	/**
	 * The main method of the application. This is the method to be called to
	 * launch the pmachine (i.e. java MainClass). It delegates to
	 * pmachine.PMachine.main.
	 * 
	 * @param args
	 *            the command line arguments.
	 * @throws RuntimeException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException,
			IOException, RuntimeException {
		pmachine.PMachine.enterPoint(args);
	}

}
