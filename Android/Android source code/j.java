// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.support.v4.b.b;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            ae, Fragment, k, w

final class j extends ae
    implements Runnable
{

    final w a;
    k b;
    k c;
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    boolean k;
    boolean l;
    String m;
    boolean n;
    int o;
    int p;
    CharSequence q;
    int r;
    CharSequence s;

    public j(w w1)
    {
        l = true;
        o = -1;
        a = w1;
    }

    private void a(int i1, Fragment fragment, String s1, int j1)
    {
        fragment.s = a;
        if (s1 != null)
        {
            if (fragment.y != null && !s1.equals(fragment.y))
            {
                throw new IllegalStateException((new StringBuilder()).append("Can't change tag of fragment ").append(fragment).append(": was ").append(fragment.y).append(" now ").append(s1).toString());
            }
            fragment.y = s1;
        }
        if (i1 != 0)
        {
            if (fragment.w != 0 && fragment.w != i1)
            {
                throw new IllegalStateException((new StringBuilder()).append("Can't change container ID of fragment ").append(fragment).append(": was ").append(fragment.w).append(" now ").append(i1).toString());
            }
            fragment.w = i1;
            fragment.x = i1;
        }
        k k1 = new k();
        k1.c = j1;
        k1.d = fragment;
        a(k1);
    }

    public int a()
    {
        return a(false);
    }

    int a(boolean flag)
    {
        if (n)
        {
            throw new IllegalStateException("commit already called");
        }
        if (w.a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Commit: ").append(this).toString());
            a("  ", ((FileDescriptor) (null)), new PrintWriter(new b("FragmentManager")), ((String []) (null)));
        }
        n = true;
        if (k)
        {
            o = a.a(this);
        } else
        {
            o = -1;
        }
        a.a(this, flag);
        return o;
    }

    public ae a(int i1, Fragment fragment, String s1)
    {
        a(i1, fragment, s1, 1);
        return this;
    }

    public ae a(Fragment fragment)
    {
        k k1 = new k();
        k1.c = 6;
        k1.d = fragment;
        a(k1);
        return this;
    }

    void a(int i1)
    {
        if (k)
        {
            if (w.a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("Bump nesting in ").append(this).append(" by ").append(i1).toString());
            }
            k k1 = b;
            while (k1 != null) 
            {
                if (k1.d != null)
                {
                    Fragment fragment1 = k1.d;
                    fragment1.r = i1 + fragment1.r;
                    if (w.a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("Bump nesting of ").append(k1.d).append(" to ").append(k1.d.r).toString());
                    }
                }
                if (k1.i != null)
                {
                    for (int j1 = -1 + k1.i.size(); j1 >= 0; j1--)
                    {
                        Fragment fragment = (Fragment)k1.i.get(j1);
                        fragment.r = i1 + fragment.r;
                        if (w.a)
                        {
                            Log.v("FragmentManager", (new StringBuilder()).append("Bump nesting of ").append(fragment).append(" to ").append(fragment.r).toString());
                        }
                    }

                }
                k1 = k1.a;
            }
        }
    }

    void a(k k1)
    {
        if (b == null)
        {
            c = k1;
            b = k1;
        } else
        {
            k1.b = c;
            c.a = k1;
            c = k1;
        }
        k1.e = e;
        k1.f = f;
        k1.g = g;
        k1.h = h;
        d = 1 + d;
    }

    public void a(String s1, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        a(s1, printwriter, true);
    }

    public void a(String s1, PrintWriter printwriter, boolean flag)
    {
        String s2;
        int i1;
        k k2;
        if (flag)
        {
            printwriter.print(s1);
            printwriter.print("mName=");
            printwriter.print(m);
            printwriter.print(" mIndex=");
            printwriter.print(o);
            printwriter.print(" mCommitted=");
            printwriter.println(n);
            if (i != 0)
            {
                printwriter.print(s1);
                printwriter.print("mTransition=#");
                printwriter.print(Integer.toHexString(i));
                printwriter.print(" mTransitionStyle=#");
                printwriter.println(Integer.toHexString(j));
            }
            if (e != 0 || f != 0)
            {
                printwriter.print(s1);
                printwriter.print("mEnterAnim=#");
                printwriter.print(Integer.toHexString(e));
                printwriter.print(" mExitAnim=#");
                printwriter.println(Integer.toHexString(f));
            }
            if (g != 0 || h != 0)
            {
                printwriter.print(s1);
                printwriter.print("mPopEnterAnim=#");
                printwriter.print(Integer.toHexString(g));
                printwriter.print(" mPopExitAnim=#");
                printwriter.println(Integer.toHexString(h));
            }
            if (p != 0 || q != null)
            {
                printwriter.print(s1);
                printwriter.print("mBreadCrumbTitleRes=#");
                printwriter.print(Integer.toHexString(p));
                printwriter.print(" mBreadCrumbTitleText=");
                printwriter.println(q);
            }
            if (r != 0 || s != null)
            {
                printwriter.print(s1);
                printwriter.print("mBreadCrumbShortTitleRes=#");
                printwriter.print(Integer.toHexString(r));
                printwriter.print(" mBreadCrumbShortTitleText=");
                printwriter.println(s);
            }
        }
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_809;
        }
        printwriter.print(s1);
        printwriter.println("Operations:");
        s2 = (new StringBuilder()).append(s1).append("    ").toString();
        k k1 = b;
        i1 = 0;
        k2 = k1;
_L13:
        if (k2 == null) goto _L2; else goto _L1
_L1:
        k2.c;
        JVM INSTR tableswitch 0 7: default 416
    //                   0 691
    //                   1 699
    //                   2 707
    //                   3 715
    //                   4 723
    //                   5 731
    //                   6 739
    //                   7 747;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L11:
        break MISSING_BLOCK_LABEL_747;
_L3:
        String s3 = (new StringBuilder()).append("cmd=").append(k2.c).toString();
_L12:
        printwriter.print(s1);
        printwriter.print("  Op #");
        printwriter.print(i1);
        printwriter.print(": ");
        printwriter.print(s3);
        printwriter.print(" ");
        printwriter.println(k2.d);
        if (flag)
        {
            if (k2.e != 0 || k2.f != 0)
            {
                printwriter.print(s1);
                printwriter.print("enterAnim=#");
                printwriter.print(Integer.toHexString(k2.e));
                printwriter.print(" exitAnim=#");
                printwriter.println(Integer.toHexString(k2.f));
            }
            if (k2.g != 0 || k2.h != 0)
            {
                printwriter.print(s1);
                printwriter.print("popEnterAnim=#");
                printwriter.print(Integer.toHexString(k2.g));
                printwriter.print(" popExitAnim=#");
                printwriter.println(Integer.toHexString(k2.h));
            }
        }
        if (k2.i != null && k2.i.size() > 0)
        {
            int j1 = 0;
            while (j1 < k2.i.size()) 
            {
                printwriter.print(s2);
                if (k2.i.size() == 1)
                {
                    printwriter.print("Removed: ");
                } else
                {
                    if (j1 == 0)
                    {
                        printwriter.println("Removed:");
                    }
                    printwriter.print(s2);
                    printwriter.print("  #");
                    printwriter.print(j1);
                    printwriter.print(": ");
                }
                printwriter.println(k2.i.get(j1));
                j1++;
            }
        }
        break MISSING_BLOCK_LABEL_796;
_L4:
        s3 = "NULL";
          goto _L12
_L5:
        s3 = "ADD";
          goto _L12
_L6:
        s3 = "REPLACE";
          goto _L12
_L7:
        s3 = "REMOVE";
          goto _L12
_L8:
        s3 = "HIDE";
          goto _L12
_L9:
        s3 = "SHOW";
          goto _L12
_L10:
        s3 = "DETACH";
          goto _L12
        s3 = "ATTACH";
          goto _L12
        k2 = k2.a;
        i1++;
          goto _L13
_L2:
    }

    public ae b(Fragment fragment)
    {
        k k1 = new k();
        k1.c = 7;
        k1.d = fragment;
        a(k1);
        return this;
    }

    public String b()
    {
        return m;
    }

    public void b(boolean flag)
    {
        k k1;
        if (w.a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("popFromBackStack: ").append(this).toString());
            a("  ", ((FileDescriptor) (null)), new PrintWriter(new b("FragmentManager")), ((String []) (null)));
        }
        a(-1);
        k1 = c;
_L10:
        if (k1 == null)
        {
            break MISSING_BLOCK_LABEL_468;
        }
        k1.c;
        JVM INSTR tableswitch 1 7: default 116
    //                   1 147
    //                   2 190
    //                   3 291
    //                   4 319
    //                   5 357
    //                   6 395
    //                   7 433;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_433;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown cmd: ").append(k1.c).toString());
_L2:
        Fragment fragment7 = k1.d;
        fragment7.G = k1.h;
        a.a(fragment7, w.c(i), j);
_L11:
        k1 = k1.b;
        if (true) goto _L10; else goto _L9
_L9:
        Fragment fragment5 = k1.d;
        if (fragment5 != null)
        {
            fragment5.G = k1.h;
            a.a(fragment5, w.c(i), j);
        }
        if (k1.i != null)
        {
            int i1 = 0;
            while (i1 < k1.i.size()) 
            {
                Fragment fragment6 = (Fragment)k1.i.get(i1);
                fragment6.G = k1.g;
                a.a(fragment6, false);
                i1++;
            }
        }
          goto _L11
_L4:
        Fragment fragment4 = k1.d;
        fragment4.G = k1.g;
        a.a(fragment4, false);
          goto _L11
_L5:
        Fragment fragment3 = k1.d;
        fragment3.G = k1.g;
        a.c(fragment3, w.c(i), j);
          goto _L11
_L6:
        Fragment fragment2 = k1.d;
        fragment2.G = k1.h;
        a.b(fragment2, w.c(i), j);
          goto _L11
_L7:
        Fragment fragment1 = k1.d;
        fragment1.G = k1.g;
        a.e(fragment1, w.c(i), j);
          goto _L11
        Fragment fragment = k1.d;
        fragment.G = k1.g;
        a.d(fragment, w.c(i), j);
          goto _L11
        if (flag)
        {
            a.a(a.n, w.c(i), j, true);
        }
        if (o >= 0)
        {
            a.b(o);
            o = -1;
        }
        return;
    }

    public void run()
    {
        k k1;
        if (w.a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Run: ").append(this).toString());
        }
        if (k && o < 0)
        {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        a(1);
        k1 = b;
_L10:
        if (k1 == null)
        {
            break MISSING_BLOCK_LABEL_639;
        }
        k1.c;
        JVM INSTR tableswitch 1 7: default 116
    //                   1 147
    //                   2 180
    //                   3 470
    //                   4 505
    //                   5 540
    //                   6 575
    //                   7 607;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_607;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown cmd: ").append(k1.c).toString());
_L2:
        Fragment fragment8 = k1.d;
        fragment8.G = k1.e;
        a.a(fragment8, false);
_L11:
        k1 = k1.a;
        if (true) goto _L10; else goto _L9
_L9:
        Fragment fragment5 = k1.d;
        Fragment fragment6;
        if (a.g != null)
        {
            int i1 = 0;
            fragment6 = fragment5;
            while (i1 < a.g.size()) 
            {
                Fragment fragment7 = (Fragment)a.g.get(i1);
                if (w.a)
                {
                    Log.v("FragmentManager", (new StringBuilder()).append("OP_REPLACE: adding=").append(fragment6).append(" old=").append(fragment7).toString());
                }
                if (fragment6 == null || fragment7.x == fragment6.x)
                {
                    if (fragment7 == fragment6)
                    {
                        fragment6 = null;
                        k1.d = null;
                    } else
                    {
                        if (k1.i == null)
                        {
                            k1.i = new ArrayList();
                        }
                        k1.i.add(fragment7);
                        fragment7.G = k1.f;
                        if (k)
                        {
                            fragment7.r = 1 + fragment7.r;
                            if (w.a)
                            {
                                Log.v("FragmentManager", (new StringBuilder()).append("Bump nesting of ").append(fragment7).append(" to ").append(fragment7.r).toString());
                            }
                        }
                        a.a(fragment7, i, j);
                    }
                }
                i1++;
            }
        } else
        {
            fragment6 = fragment5;
        }
        if (fragment6 != null)
        {
            fragment6.G = k1.e;
            a.a(fragment6, false);
        }
          goto _L11
_L4:
        Fragment fragment4 = k1.d;
        fragment4.G = k1.f;
        a.a(fragment4, i, j);
          goto _L11
_L5:
        Fragment fragment3 = k1.d;
        fragment3.G = k1.f;
        a.b(fragment3, i, j);
          goto _L11
_L6:
        Fragment fragment2 = k1.d;
        fragment2.G = k1.e;
        a.c(fragment2, i, j);
          goto _L11
_L7:
        Fragment fragment1 = k1.d;
        fragment1.G = k1.f;
        a.d(fragment1, i, j);
          goto _L11
        Fragment fragment = k1.d;
        fragment.G = k1.e;
        a.e(fragment, i, j);
          goto _L11
        a.a(a.n, i, j, true);
        if (k)
        {
            a.b(this);
        }
        return;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("BackStackEntry{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (o >= 0)
        {
            stringbuilder.append(" #");
            stringbuilder.append(o);
        }
        if (m != null)
        {
            stringbuilder.append(" ");
            stringbuilder.append(m);
        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }
}
