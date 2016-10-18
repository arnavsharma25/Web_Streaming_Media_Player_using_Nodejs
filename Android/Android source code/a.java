// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.b;
import android.view.View;

// Referenced classes of package android.support.v4.app:
//            e, d, c, f

public class a
    implements b
{

    private static final c a;
    private final Activity b;
    private final DrawerLayout c;
    private boolean d;
    private Drawable e;
    private Drawable f;
    private f g;
    private final int h;
    private final int i;
    private final int j;
    private Object k;

    public a(Activity activity, DrawerLayout drawerlayout, int l, int i1, int j1)
    {
        d = true;
        b = activity;
        c = drawerlayout;
        h = l;
        i = i1;
        j = j1;
        e = a.a(activity);
        f = activity.getResources().getDrawable(l);
        g = new f(f);
        g.b(0.3333333F);
    }

    public void a(int l)
    {
    }

    public void a(View view)
    {
        g.a(1.0F);
        if (d)
        {
            k = a.a(k, b, i);
        }
    }

    public void a(View view, float f1)
    {
        float f2 = g.a();
        float f3;
        if (f1 > 0.5F)
        {
            f3 = Math.max(f2, 2.0F * Math.max(0.0F, f1 - 0.5F));
        } else
        {
            f3 = Math.min(f2, f1 * 2.0F);
        }
        g.a(f3);
    }

    public void b(View view)
    {
        g.a(0.0F);
        if (d)
        {
            k = a.a(k, b, j);
        }
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new e(null);
        } else
        {
            a = new d(null);
        }
    }
}
