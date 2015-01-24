# Duplicate Emails 
# Write a SQL query to find all duplicate emails in a table named Person.
# 
# +----+---------+
# | Id | Email   |
# +----+---------+
# | 1  | a@b.com |
# | 2  | c@d.com |
# | 3  | a@b.com |
# +----+---------+
# For example, your query should return the following for the above table:
# 
# +---------+
# | Email   |
# +---------+
# | a@b.com |
# +---------+

# Write your MySQL query statement below
SELECT Email FROM (
SELECT Email, COUNT(*) AS Count FROM Person GROUP BY Email
) c 
WHERE c.Count > 1;
