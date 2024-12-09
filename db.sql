--
-- PostgreSQL database dump
--

-- Dumped from database version 17.1
-- Dumped by pg_dump version 17.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: book; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.book (
    title text NOT NULL,
    publishtime timestamp with time zone,
    total integer NOT NULL,
    available integer NOT NULL,
    count integer NOT NULL,
    show boolean NOT NULL,
    index text,
    author text,
    id integer NOT NULL
);


ALTER TABLE public.book OWNER TO postgres;

--
-- Name: TABLE book; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.book IS '图书表';


--
-- Name: COLUMN book.index; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.book.index IS '索书号';


--
-- Name: book_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.book_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.book_id_seq OWNER TO postgres;

--
-- Name: book_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.book_id_seq OWNED BY public.book.id;


--
-- Name: log; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.log (
    userid integer NOT NULL,
    type integer NOT NULL,
    info text,
    "time" timestamp with time zone NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.log OWNER TO postgres;

--
-- Name: TABLE log; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.log IS '日志表';


--
-- Name: log_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.log_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.log_id_seq OWNER TO postgres;

--
-- Name: log_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.log_id_seq OWNED BY public.log.id;


--
-- Name: paper; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.paper (
    title text NOT NULL,
    uploader integer,
    uploadtime timestamp with time zone,
    count integer NOT NULL,
    show boolean NOT NULL,
    id integer NOT NULL,
    author text
);


ALTER TABLE public.paper OWNER TO postgres;

--
-- Name: TABLE paper; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.paper IS '论文表';


--
-- Name: paper_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.paper_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.paper_id_seq OWNER TO postgres;

--
-- Name: paper_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.paper_id_seq OWNED BY public.paper.id;


--
-- Name: record; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.record (
    bookid integer NOT NULL,
    userid integer NOT NULL,
    karutime date,
    kaesutime date,
    status integer NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.record OWNER TO postgres;

--
-- Name: TABLE record; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.record IS '借阅记录';


--
-- Name: record_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.record_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.record_id_seq OWNER TO postgres;

--
-- Name: record_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.record_id_seq OWNED BY public.record.id;


--
-- Name: test; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.test (
    username text,
    password text
);


ALTER TABLE public.test OWNER TO postgres;

--
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
    username text NOT NULL,
    password text NOT NULL,
    type integer NOT NULL,
    regtime timestamp with time zone NOT NULL,
    name text NOT NULL,
    id integer NOT NULL,
    phone text,
    email text
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- Name: COLUMN "user".type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public."user".type IS '用户类型';


--
-- Name: COLUMN "user".regtime; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public."user".regtime IS '注册时间';


--
-- Name: COLUMN "user".name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public."user".name IS '真实姓名';


--
-- Name: COLUMN "user".phone; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public."user".phone IS '手机号';


--
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.user_id_seq OWNER TO postgres;

--
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_id_seq OWNED BY public."user".id;


--
-- Name: usertest; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usertest (
    username text,
    password text,
    id integer NOT NULL,
    type integer DEFAULT 3,
    regtime timestamp with time zone,
    name text,
    phone text,
    email text
);


ALTER TABLE public.usertest OWNER TO postgres;

--
-- Name: usertest_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usertest_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.usertest_id_seq OWNER TO postgres;

--
-- Name: usertest_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usertest_id_seq OWNED BY public.usertest.id;


--
-- Name: book id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book ALTER COLUMN id SET DEFAULT nextval('public.book_id_seq'::regclass);


--
-- Name: log id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.log ALTER COLUMN id SET DEFAULT nextval('public.log_id_seq'::regclass);


--
-- Name: paper id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paper ALTER COLUMN id SET DEFAULT nextval('public.paper_id_seq'::regclass);


--
-- Name: record id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.record ALTER COLUMN id SET DEFAULT nextval('public.record_id_seq'::regclass);


--
-- Name: user id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user" ALTER COLUMN id SET DEFAULT nextval('public.user_id_seq'::regclass);


--
-- Name: usertest id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usertest ALTER COLUMN id SET DEFAULT nextval('public.usertest_id_seq'::regclass);


--
-- Data for Name: book; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.book (title, publishtime, total, available, count, show, index, author, id) FROM stdin;
dasd	2024-12-09 19:25:54.711+08	2	1	2	t	sqada	asdad	2
dasd	2024-12-09 19:25:54.711+08	2	1	2	t	sqada	asdad	3
aaaaa	\N	4	1	0	f	dsgsdfg	gfdhdfg	6
aaaaasf	\N	4	1	0	f	dsgsdfgfsfa	gfdhdfg	7
fsaf	\N	523	13	0	f	gdsg	fsaf	8
\.


--
-- Data for Name: log; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.log (userid, type, info, "time", id) FROM stdin;
\.


--
-- Data for Name: paper; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.paper (title, uploader, uploadtime, count, show, id, author) FROM stdin;
12	1	2024-12-09 02:15:55.673+08	0	t	2	123
123	1	2024-12-09 11:12:51.193+08	0	t	3	21312312
\.


--
-- Data for Name: record; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.record (bookid, userid, karutime, kaesutime, status, id) FROM stdin;
\.


--
-- Data for Name: test; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.test (username, password) FROM stdin;
\.


--
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."user" (username, password, type, regtime, name, id, phone, email) FROM stdin;
\.


--
-- Data for Name: usertest; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usertest (username, password, id, type, regtime, name, phone, email) FROM stdin;
lemonaaaaaaaaa	12345	6	3	2024-11-28 09:38:02.795+08	\N	\N	\N
lemodsad	12345	8	3	2024-11-28 09:38:30.754+08	\N	\N	\N
lemonasdasd	12345	9	3	2024-11-28 09:42:49.493+08	\N	\N	\N
lemonasdasdsss	12345	10	3	2024-11-28 09:43:04.108+08	\N	\N	\N
lemonsadas	12345	11	3	2024-11-28 09:43:29.155+08	\N	\N	\N
lemon	111111	1	1	2024-11-28 04:58:07.931+08	llmmm	123123444	123124@wr.com
lemona	12345	2	2	2024-11-28 09:33:57.455+08	\N	\N	\N
lemonaaaaaaa	12345	5	2	2024-11-28 09:37:38.474+08	\N	\N	\N
lemonaaaaaaaaaa	12345	7	2	2024-11-28 09:38:06.302+08	\N	\N	\N
aaaa	12312312	20	2	2024-12-09 13:45:55.354+08	dsfsad	123123	123123@qq.com
\.


--
-- Name: book_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.book_id_seq', 8, true);


--
-- Name: log_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.log_id_seq', 1, false);


--
-- Name: paper_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.paper_id_seq', 3, true);


--
-- Name: record_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.record_id_seq', 1, false);


--
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_id_seq', 1, false);


--
-- Name: usertest_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usertest_id_seq', 20, true);


--
-- Name: book book_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (id);


--
-- Name: log log_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.log
    ADD CONSTRAINT log_pkey PRIMARY KEY (id);


--
-- Name: paper paper_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paper
    ADD CONSTRAINT paper_pkey PRIMARY KEY (id);


--
-- Name: record record_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.record
    ADD CONSTRAINT record_pkey PRIMARY KEY (id);


--
-- Name: test test_username_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_username_key UNIQUE (username);


--
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- Name: user user_username_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_username_key UNIQUE (username);


--
-- Name: usertest usertest_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usertest
    ADD CONSTRAINT usertest_pkey PRIMARY KEY (id);


--
-- Name: usertest usertest_username_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usertest
    ADD CONSTRAINT usertest_username_key UNIQUE (username);


--
-- PostgreSQL database dump complete
--

