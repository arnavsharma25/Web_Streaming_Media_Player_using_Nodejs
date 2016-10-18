// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.content.Context;
import android.os.Parcelable;
import android.widget.TabHost;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            ad, u, ae, Fragment

public class FragmentTabHost extends TabHost
    implements android.widget.TabHost.OnTabChangeListener
{

    private final ArrayList a;
    private Context b;
    private u c;
    private int d;
    private android.widget.TabHost.OnTabChangeListener e;
    private ad f;
    private boolean g;

    private ae a(String s, ae ae1)
    {
        ad ad1 = null;
        int i = 0;
        while (i < a.size()) 
        {
            ad ad2 = (ad)a.get(i);
            if (!ad.b(ad2).equals(s))
            {
                ad2 = ad1;
            }
            i++;
            ad1 = ad2;
        }
        if (ad1 == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("No tab known for tag ").append(s).toString());
        }
        if (f != ad1)
        {
            if (ae1 == null)
            {
                ae1 = c.a();
            }
            if (f != null && ad.a(f) != null)
            {
                ae1.a(ad.a(f));
            }
            if (ad1 != null)
            {
                if (ad.a(ad1) == null)
                {
                    ad.a(ad1, Fragment.a(b, ad.c(ad1).getName(), ad.d(ad1)));
                    ae1.a(d, ad.a(ad1), ad.b(ad1));
                } else
                {
                    ae1.b(ad.a(ad1));
                }
            }
            f = ad1;
        }
        return ae1;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        String s = getCurrentTabTag();
        ae ae1 = null;
        int i = 0;
        while (i < a.size()) 
        {
            ad ad1 = (ad)a.get(i);
            ad.a(ad1, c.a(ad.b(ad1)));
            if (ad.a(ad1) != null && !ad.a(ad1).d())
            {
                if (ad.b(ad1).equals(s))
                {
                    f = ad1;
                } else
                {
                    if (ae1 == null)
                    {
                        ae1 = c.a();
                    }
                    ae1.a(ad.a(ad1));
                }
            }
            i++;
        }
        g = true;
        ae ae2 = a(s, ae1);
        if (ae2 != null)
        {
            ae2.a();
            c.b();
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        g = false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        setCurrentTabByTag(savedstate.a);
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = getCurrentTabTag();
        return savedstate;
    }

    public void onTabChanged(String s)
    {
        if (g)
        {
            ae ae1 = a(s, null);
            if (ae1 != null)
            {
                ae1.a();
            }
        }
        if (e != null)
        {
            e.onTabChanged(s);
        }
    }

    public void setOnTabChangedListener(android.widget.TabHost.OnTabChangeListener ontabchangelistener)
    {
        e = ontabchangelistener;
    }

    public void setup()
    {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new ac();
        String a;

        public String toString()
        {
            return (new StringBuilder()).append("FragmentTabHost.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" curTab=").append(a).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeString(a);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            a = parcel.readString();
        }

        SavedState(Parcel parcel, ab ab)
        {
            this(parcel);
        }

        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
