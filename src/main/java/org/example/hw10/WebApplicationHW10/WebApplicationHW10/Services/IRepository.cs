﻿using WebApplicationHW10.Models;

namespace WebApplicationHW10.Services
{
    public interface IRepository<T, TId>
    {
        int Create(T item);
        int Update(T item);

        int Delete(TId id);

        T GetById(TId id);
        List<T> GetAll();
    }
}
