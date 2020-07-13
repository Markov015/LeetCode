class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        multiset<int> s1, s2;
        for(int x : nums1) {
            s1.insert(x);
        }
        for(int x : nums2) {
            s2.insert(x);
        }
        vector<int> res;
        set_intersection(s1.begin(), s1.end(), s2.begin(), s2.end(), back_inserter(res));
        return res;
    }
};

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        map<int, int> map1, map2;
        for (int num : nums1) {
            ++map1[num];
        }
        for (int num: nums2) {
            ++map2[num];
        }
        vector<int> v;
        for (auto p : map1) {
            for (int i = 0; i < min(p.second, map2[p.first]); i++) {
                v.push_back(p.first);
            }
        }
        return v;
    }
};
