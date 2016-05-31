class solve549
{
    static int top = 100000000;
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
					int count = 0;
					int copy = j*i;
					int newValue = 0;
					int k = 1;
					while (copy%i == 0)
					{
						count++;
						copy /= i;
					}
					while (count > 0)
					{
						int kCopy = k;
						while (kCopy%i == 0)
						{
							count--;
							kCopy /= i;
						}
						count--;
						if (count <= 0)
							break;
						k++;
					}
					
					newValue = k*i;
                    if (sValues[j*i] < newValue)
                        sValues[j*i] = newValue;
                    j++;
                }
            }
        }

        long sum = 0;
        
        for (int i=0; i<=top; i++)
        {
            // System.out.println("s(" + i + ") = " + sValues[i]);
            sum += (long)sValues[i];
        }

        System.out.println("total = " + sum);
        
        
        final long endTime = System.currentTimeMillis();
        
        System.out.println();
        System.out.println();
        System.out.println("Time : " + (endTime - startTime));
    }
}
