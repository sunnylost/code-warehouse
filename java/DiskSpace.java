/*
As of late, your usually high-performance computer has been acting rather sluggish. 
You come to realize that while you have plenty of free disk space on your machine, 
it is split up over many hard drives. 
You decide that the secret to improving performance is to consolidate all the data on your computer onto 
as few hard drives as possible.

Given a int[] used, representing the amount of disk space used on each drive, and a corresponding int[] total, 
representing the total capacity of each drive mentioned in used, 
you should attempt to pack the data onto as few hard drives as possible. 
You may assume that the data consists of very small files, 
such that splitting it up and moving parts of it onto different hard drives never presents a problem. 
Return the minimum number of hard drives that still contain data after the consolidation is complete.
*/
import java.util.Arrays;
import java.util.Collections;

public class DiskSpace {
	int minDrives(int[] used, int[] total) throws Exception {
		int len = used == null ? 0 : used.length;
		Integer[] forSortArray = new Integer[len];
		int u, t, 
			uSum = 0, 
			tSum = 0,
			i = 0,
			num = 0;
		if(len < 1 || len > 50) {
			throw new Exception("used's length must between 1 and 50.");
		}
		if(total == null || total.length != len) {
			throw new Exception("total's length must equal to used's");
		}
		for(; i < len; i++) {
			u = used[i];
			t = total[i];
			forSortArray[i] = t;
			if(u < 1 || t < 1 || u > 1000 || t > 1000) {
				throw new Exception("used's and total's item must between 1 and 1000");
			}
			if(u > t) {
				throw new Exception("used's item must less or equal than total's item.");
			}
			tSum += t;
			uSum += u;
		}
		Arrays.sort(forSortArray, Collections.reverseOrder());
		for(i = 0; i < len; i++) {
			uSum -= forSortArray[i];
			num++;
			if(uSum <= 0) break;
		}
		return num;
	}

	public static void main(String[] args) {
		int[] used = {331,242,384,366,428,114,145,89,381,170,329,190,482,246,2,38,220,290,402,385};
		int[] total = {992,509,997,946,976,873,771,565,693,714,755,878,897,789,969,727,765,521,961,906};
		
		try {
			System.out.println(new DiskSpace().minDrives(used, total));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
