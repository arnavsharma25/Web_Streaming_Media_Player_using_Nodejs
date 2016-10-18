// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            l, j, k, Fragment, 
//            w

final class BackStackState
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new l();
    final int a[];
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;

    public BackStackState(Parcel parcel)
    {
        a = parcel.createIntArray();
        b = parcel.readInt();
        c = parcel.readInt();
        d = parcel.readString();
        e = parcel.readInt();
        f = parcel.readInt();
        g = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        h = parcel.readInt();
        i = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    public BackStackState(w w1, j j1)
    {
        k k1 = j1.b;
        int i1 = 0;
        for (; k1 != null; k1 = k1.a)
        {
            if (k1.i != null)
            {
                i1 += k1.i.size();
            }
        }

        a = new int[i1 + 7 * j1.d];
        if (!j1.k)
        {
            throw new IllegalStateException("Not on back stack");
        }
        k k2 = j1.b;
        int l1 = 0;
        while (k2 != null) 
        {
            int ai[] = a;
            int i2 = l1 + 1;
            ai[l1] = k2.c;
            int ai1[] = a;
            int j2 = i2 + 1;
            int l2;
            int ai2[];
            int i3;
            int ai3[];
            int j3;
            int ai4[];
            int k3;
            int ai5[];
            int l3;
            if (k2.d != null)
            {
                l2 = k2.d.f;
            } else
            {
                l2 = -1;
            }
            ai1[i2] = l2;
            ai2 = a;
            i3 = j2 + 1;
            ai2[j2] = k2.e;
            ai3 = a;
            j3 = i3 + 1;
            ai3[i3] = k2.f;
            ai4 = a;
            k3 = j3 + 1;
            ai4[j3] = k2.g;
            ai5 = a;
            l3 = k3 + 1;
            ai5[k3] = k2.h;
            if (k2.i != null)
            {
                int i4 = k2.i.size();
                int ai7[] = a;
                int j4 = l3 + 1;
                ai7[l3] = i4;
                for (int k4 = 0; k4 < i4;)
                {
                    int ai8[] = a;
                    int l4 = j4 + 1;
                    ai8[j4] = ((Fragment)k2.i.get(k4)).f;
                    k4++;
                    j4 = l4;
                }

                l1 = j4;
            } else
            {
                int ai6[] = a;
                l1 = l3 + 1;
                ai6[l3] = 0;
            }
            k2 = k2.a;
        }
        b = j1.i;
        c = j1.j;
        d = j1.m;
        e = j1.o;
        f = j1.p;
        g = j1.q;
        h = j1.r;
        i = j1.s;
    }

    public j a(w w1)
    {
        j j1 = new j(w1);
        int i1 = 0;
        int l3;
        for (int k1 = 0; k1 < a.length; k1 = l3)
        {
            k k2 = new k();
            int ai[] = a;
            int l1 = k1 + 1;
            k2.c = ai[k1];
            if (w.a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("Instantiate ").append(j1).append(" op #").append(i1).append(" base fragment #").append(a[l1]).toString());
            }
            int ai1[] = a;
            int i2 = l1 + 1;
            int j2 = ai1[l1];
            int ai2[];
            int l2;
            int ai3[];
            int i3;
            int ai4[];
            int j3;
            int ai5[];
            int k3;
            int ai6[];
            int i4;
            if (j2 >= 0)
            {
                k2.d = (Fragment)w1.f.get(j2);
            } else
            {
                k2.d = null;
            }
            ai2 = a;
            l2 = i2 + 1;
            k2.e = ai2[i2];
            ai3 = a;
            i3 = l2 + 1;
            k2.f = ai3[l2];
            ai4 = a;
            j3 = i3 + 1;
            k2.g = ai4[i3];
            ai5 = a;
            k3 = j3 + 1;
            k2.h = ai5[j3];
            ai6 = a;
            l3 = k3 + 1;
            i4 = ai6[k3];
            if (i4 > 0)
            {
                k2.i = new ArrayList(i4);
                for (int j4 = 0; j4 < i4;)
                {
                    if (w.a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("Instantiate ").append(j1).append(" set remove fragment #").append(a[l3]).toString());
                    }
                    ArrayList arraylist = w1.f;
                    int ai7[] = a;
                    int k4 = l3 + 1;
                    Fragment fragment = (Fragment)arraylist.get(ai7[l3]);
                    k2.i.add(fragment);
                    j4++;
                    l3 = k4;
                }

            }
            j1.a(k2);
            i1++;
        }

        j1.i = b;
        j1.j = c;
        j1.m = d;
        j1.o = e;
        j1.k = true;
        j1.p = f;
        j1.q = g;
        j1.r = h;
        j1.s = i;
        j1.a(1);
        return j1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        parcel.writeIntArray(a);
        parcel.writeInt(b);
        parcel.writeInt(c);
        parcel.writeString(d);
        parcel.writeInt(e);
        parcel.writeInt(f);
        TextUtils.writeToParcel(g, parcel, 0);
        parcel.writeInt(h);
        TextUtils.writeToParcel(i, parcel, 0);
    }

}
