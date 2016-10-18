// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.support.v4.b.a;
import android.support.v4.b.c;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package android.support.v4.app:
//            af, ai, FragmentActivity

class ah extends af
{

    static boolean a = false;
    final c b = new c();
    final c c = new c();
    final String d;
    FragmentActivity e;
    boolean f;
    boolean g;

    ah(String s, FragmentActivity fragmentactivity, boolean flag)
    {
        d = s;
        e = fragmentactivity;
        f = flag;
    }

    void a(FragmentActivity fragmentactivity)
    {
        e = fragmentactivity;
    }

    public void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        int i = 0;
        if (b.a() > 0)
        {
            printwriter.print(s);
            printwriter.println("Active Loaders:");
            String s2 = (new StringBuilder()).append(s).append("    ").toString();
            for (int j = 0; j < b.a(); j++)
            {
                ai ai2 = (ai)b.b(j);
                printwriter.print(s);
                printwriter.print("  #");
                printwriter.print(b.a(j));
                printwriter.print(": ");
                printwriter.println(ai2.toString());
                ai2.a(s2, filedescriptor, printwriter, as);
            }

        }
        if (c.a() > 0)
        {
            printwriter.print(s);
            printwriter.println("Inactive Loaders:");
            String s1 = (new StringBuilder()).append(s).append("    ").toString();
            for (; i < c.a(); i++)
            {
                ai ai1 = (ai)c.b(i);
                printwriter.print(s);
                printwriter.print("  #");
                printwriter.print(c.a(i));
                printwriter.print(": ");
                printwriter.println(ai1.toString());
                ai1.a(s1, filedescriptor, printwriter, as);
            }

        }
    }

    public boolean a()
    {
        int i = b.a();
        int j = 0;
        boolean flag = false;
        while (j < i) 
        {
            ai ai1 = (ai)b.b(j);
            boolean flag1;
            if (ai1.h && !ai1.f)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag |= flag1;
            j++;
        }
        return flag;
    }

    void b()
    {
        if (a)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("Starting in ").append(this).toString());
        }
        if (f)
        {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder()).append("Called doStart when already started: ").append(this).toString(), runtimeexception);
        } else
        {
            f = true;
            int i = -1 + b.a();
            while (i >= 0) 
            {
                ((ai)b.b(i)).a();
                i--;
            }
        }
    }

    void c()
    {
        if (a)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("Stopping in ").append(this).toString());
        }
        if (!f)
        {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder()).append("Called doStop when not started: ").append(this).toString(), runtimeexception);
            return;
        }
        for (int i = -1 + b.a(); i >= 0; i--)
        {
            ((ai)b.b(i)).e();
        }

        f = false;
    }

    void d()
    {
        if (a)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("Retaining in ").append(this).toString());
        }
        if (!f)
        {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder()).append("Called doRetain when not started: ").append(this).toString(), runtimeexception);
        } else
        {
            g = true;
            f = false;
            int i = -1 + b.a();
            while (i >= 0) 
            {
                ((ai)b.b(i)).b();
                i--;
            }
        }
    }

    void e()
    {
        if (g)
        {
            if (a)
            {
                Log.v("LoaderManager", (new StringBuilder()).append("Finished Retaining in ").append(this).toString());
            }
            g = false;
            for (int i = -1 + b.a(); i >= 0; i--)
            {
                ((ai)b.b(i)).c();
            }

        }
    }

    void f()
    {
        for (int i = -1 + b.a(); i >= 0; i--)
        {
            ((ai)b.b(i)).k = true;
        }

    }

    void g()
    {
        for (int i = -1 + b.a(); i >= 0; i--)
        {
            ((ai)b.b(i)).d();
        }

    }

    void h()
    {
        if (!g)
        {
            if (a)
            {
                Log.v("LoaderManager", (new StringBuilder()).append("Destroying Active in ").append(this).toString());
            }
            for (int j = -1 + b.a(); j >= 0; j--)
            {
                ((ai)b.b(j)).f();
            }

            b.b();
        }
        if (a)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("Destroying Inactive in ").append(this).toString());
        }
        for (int i = -1 + c.a(); i >= 0; i--)
        {
            ((ai)c.b(i)).f();
        }

        c.b();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("LoaderManager{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" in ");
        android.support.v4.b.a.a(e, stringbuilder);
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }

}
