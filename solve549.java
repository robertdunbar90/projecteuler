class solve549
{
    static int top = 100;
    static int[] sValues = new int[top+1];
   
    public static void main(String[] args)
    {
        final long startTime = System.currentTimeMillis();
        
        sValues[0] = 0;
        sValues[1] = 0;
        for (int i=2; i<=top; i++)
            sValues[i] = 1;
        
        for (int i=2; i<=top; i++)
        {
            if (sValues[i] == 1)
            {
                int j=1;
                while (j*i <= top)
                {
                    int newValue = i;
                    int copy = j;
                    int count = 1;
                    while (copy > 1 && copy%i == 0)
                    {
                        while (newValue > 1 && newValue%i == 0)
                        {
                            newValue /= i;
                            copy /= i;
                        }
                        copy /= i;
                        count++;
                        newValue = i*count;
                    }
                    if (sValues[j*i] < newValue)
                        sValues[j*i] = newValue;
                    j++;
                }
            }
        }

        int sum = 0;
        
        for (int i=0; i<=top; i++)
        {
            System.out.println("s(" + i + ") = " + sValues[i]);
            sum += sValues[i];
        }

        System.out.println("total = " + sum);
        
        
        final long endTime = System.currentTimeMillis();
        
        System.out.println();
        System.out.println();
        System.out.println("Time : " + (endTime - startTime));
    }
}
