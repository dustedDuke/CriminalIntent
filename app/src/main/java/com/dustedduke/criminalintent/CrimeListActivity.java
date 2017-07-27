package com.dustedduke.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by dustedduke on 27.07.17.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
