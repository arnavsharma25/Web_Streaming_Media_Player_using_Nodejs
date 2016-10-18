// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;

// Referenced classes of package android.support.v4.app:
//            Fragment

final class ad
{

    private final String a;
    private final Class b;
    private final Bundle c;
    private Fragment d;

    static Fragment a(ad ad1)
    {
        return ad1.d;
    }

    static Fragment a(ad ad1, Fragment fragment)
    {
        ad1.d = fragment;
        return fragment;
    }

    static String b(ad ad1)
    {
        return ad1.a;
    }

    static Class c(ad ad1)
    {
        return ad1.b;
    }

    static Bundle d(ad ad1)
    {
        return ad1.c;
    }
}
