/*
 * $Id$
 *
 * Copyright 2013 Moneybookers Ltd. All Rights Reserved.
 * MONEYBOOKERS PROPRIETARY/CONFIDENTIAL. For internal use only.
 */

package cvPackage;


public interface ApplicationManager {
    public void add();

    /**
     * printing all CVs
     */
    public void view();

    /**
     * Printing a CV according to its position
     */
    public void view(int position);

    public void export();

}
